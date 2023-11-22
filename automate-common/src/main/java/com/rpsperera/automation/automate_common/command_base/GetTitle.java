package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.exception.InvalidParadigmException;

import static com.rpsperera.automation.automate_common.util.Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM;

public interface GetTitle<T> extends Command<T> {
    default void getTitle() throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
}