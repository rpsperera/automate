package com.rpsperera.automation.ratcore_common.util;

import com.rpsperera.automation.ratcore_common.enums.Paradigm;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TestCaseAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCaseAdvice.class);

    @Pointcut("within(@TestCase *) && execution(* *(..))")
    public void testcase() {
    }

    @Around("testcase()")
    public Object testcaseAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        final Class<?> clazz = joinPoint.getSignature().getDeclaringType();
        TestCase annotation = clazz.getAnnotation(TestCase.class);
        String testCaseName = annotation.name();
        Paradigm paradigm = annotation.paradigm();
        LOGGER.info(String.format("Execution Started for Testcase %s::%s)", paradigm, testCaseName));
        try {
            return joinPoint.proceed();
        } finally {
            LOGGER.info(String.format("Execution Completed For Testcase %s::%s ", paradigm, testCaseName));
        }
    }
}
