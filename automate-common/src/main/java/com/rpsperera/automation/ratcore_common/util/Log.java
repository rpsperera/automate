package com.rpsperera.automation.ratcore_common.util;

import com.rpsperera.automation.ratcore_common.enums.Command;
import com.rpsperera.automation.ratcore_common.enums.Paradigm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {

    Command command();

    Paradigm paradigm();
}
