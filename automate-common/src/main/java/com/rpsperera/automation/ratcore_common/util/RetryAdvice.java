package com.rpsperera.automation.ratcore_common.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Aspect
public class RetryAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetryAdvice.class);

    // holds the command retry counts
    private Integer retryCount;

    // holds the command waitTime
    private Long waitTime;

    /**
     * pointcut for the retry annotation.
     */
    @Pointcut("@annotation(Retry) && execution(* *(..))")
    public void retry() {
    }

    /**
     * This will wrap each command with retry capability.
     *
     * @param proceedingJoinPoint - Current Instance
     * @return proceeding JointPoint
     * @throws Throwable - RuntimeException if not able to
     *                   retry.
     */
    @Around("retry()")
    public Object retryAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String methodName = proceedingJoinPoint.getSignature().getName();
        getCommandRetries(proceedingJoinPoint);
        Retry annotation = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getAnnotation(Retry.class);
        boolean continueOnFail = annotation.continueOnFail();
        boolean returnBoolean = annotation.returnBoolean();
        int attempt = 1;
        Object proceed;
        while (attempt <= (this.retryCount + 1)) {
            attempt++;
            try {
                proceed = proceedingJoinPoint.proceed();
                return proceed;
            } catch (Exception e) {
                LOGGER.error("Exception at attempt {} - {}", attempt - 1, e.getMessage());
                if (attempt >= retryCount) {
                    if (returnBoolean) {
                        LOGGER.info("Max retry attempts reached.");
                        return false;
                    }

                    if (continueOnFail) {
                        LOGGER.info("Continue On Fail :: Max retry attempts reached.");
                        LOGGER.info("Continuing to next command");
                        return true;
                    }
                    LOGGER.info("Max retry attempts reached.Throwing Exception");
                    LOGGER.error(e.getMessage(), e);
                    executeExistHandler(proceedingJoinPoint);
                    throw e;
                }
                LOGGER.info("Waiting for {}ms before retrying", waitTime);
                Thread.sleep(waitTime);
            }

        }
        throw new Exception(String.format("Unable to execute command %s", ""));
    }

    /**
     * This method will fetch retry counts for each command.
     *
     * @param proceedingJoinPoint - current executing instance.
     * @throws NoSuchFieldException - If metadata fields retryCount or
     *                              waitTime is not present in the command.
     */
    private void getCommandRetries(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchFieldException, IllegalAccessException {
        Object instance = proceedingJoinPoint.getThis();
        Field metaData = instance.getClass().getField("metaData");
        metaData.setAccessible(true);
        Optional.of(metaData.get(instance)).ifPresent(field -> {
            Optional.ofNullable(((Map<?, ?>) field).get("retryCount")).ifPresentOrElse(meta -> this.retryCount = (Integer) meta, () -> this.retryCount = 3);
            Optional.ofNullable(((Map<?, ?>) field).get("waitTime")).ifPresentOrElse(meta -> this.waitTime = (Long) meta, () -> this.waitTime = 500L);
        });

    }

    private void executeExistHandler(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchFieldException, IllegalAccessException {
        Object instance = proceedingJoinPoint.getThis();
        Field exitHandler = instance.getClass().getField("exitHandler");
        exitHandler.setAccessible(true);
        Optional.of(exitHandler.get(instance)).ifPresent(field -> ((ExitHandlerFI) field).exit());
    }
}
