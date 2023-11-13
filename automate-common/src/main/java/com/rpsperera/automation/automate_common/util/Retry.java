package com.rpsperera.automation.automate_common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Retry {

    int interval() default 500;

    int retryCount() default 3;

    boolean continueOnFail() default false;

    boolean returnsBoolean() default false;

}
