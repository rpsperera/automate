package com.rpsperera.automation.ratcore_common.util;

import com.rpsperera.automation.ratcore_common.enums.Paradigm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.rpsperera.automation.ratcore_common.enums.Paradigm.WEB;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestCase {

    Paradigm paradigm() default WEB;

    String name();

}
