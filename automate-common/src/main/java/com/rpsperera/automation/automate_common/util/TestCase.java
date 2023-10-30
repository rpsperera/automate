package com.rpsperera.automation.automate_common.util;

import com.rpsperera.automation.automate_common.enums.Paradigm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestCase {

    Paradigm paradigm() default Paradigm.WEB;

    String name();

}
