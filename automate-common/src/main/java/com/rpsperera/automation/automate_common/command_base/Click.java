package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.enums.ElementIdentifier;

public interface Click<T> extends Command<T> {

    default void click(ElementIdentifier elementIdentifier, String element) throws Exception {

    }
}
