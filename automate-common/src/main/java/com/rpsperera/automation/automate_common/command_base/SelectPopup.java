package com.rpsperera.automation.automate_common.command_base;

import static com.rpsperera.automation.automate_common.util.Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM;

import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.exception.InvalidParadigmException;

public interface SelectPopup<T> extends Command<T> {
	 
	default void acceptPopup() throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
    default void dismissPopup() throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
    default void getTextPopup() throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
    default void sendKeysPopup(String stringToSend) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
}
