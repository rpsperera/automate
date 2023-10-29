package com.rpsperera.automation.ratcore_common.util;

import com.rpsperera.automation.ratcore_common.enums.Command;
import com.rpsperera.automation.ratcore_common.enums.Paradigm;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAdvice.class);
    Command command;
    Paradigm paradigm;

    @Pointcut("@annotation(Log) && execution(* *(..))")
    private void Log() {
    }

    @Before("Log()")
    public void logBefore(JoinPoint joinPoint) {
        log(joinPoint, "Started");
    }

    @After("Log()")
    public void logAfter(JoinPoint joinPoint) {
        log(joinPoint, "Completed");
    }

    @AfterThrowing(pointcut = "Log()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        log(joinPoint, "Completed");
    }

    private void log(JoinPoint joinPoint, String state) {
        Command command = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Log.class).command();
        Paradigm paradigm = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Log.class).paradigm();
        LOGGER.info(String.format("%s Executing %s :: %s", state, paradigm.name(), command.name()));
    }
}

