package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.exception.InvalidParadigmException;

import static com.rpsperera.automation.automate_common.util.Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM;

public interface SelectFrame<T> extends Command<T> {

    default void selectFrame(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default void selectFrameById(int id) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default void selectFrameByNameOrId(String nameOrId) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
}