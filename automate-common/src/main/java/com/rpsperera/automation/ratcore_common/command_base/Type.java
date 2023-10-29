package com.rpsperera.automation.ratcore_common.command_base;

import com.rpsperera.automation.ratcore_common.enums.ElementIdentifier;

public interface Type<T> extends Command<T> {

    default void type(ElementIdentifier elementIdentifier, String element, String text) throws Exception {

    }
}
