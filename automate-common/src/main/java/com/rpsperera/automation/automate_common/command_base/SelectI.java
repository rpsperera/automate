package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.exception.InvalidParadigmException;

import static com.rpsperera.automation.automate_common.util.Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM;

/**
 * Created by dasitha on 2023-11-16
 *
 * @author dasitha
 */
public interface SelectI<T> extends Command<T> {
    default void selectByVisibleText(ElementIdentifier elementIdentifier, String element, String text) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default void selectByIndex(ElementIdentifier elementIdentifier, String element, int index) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default void selectByValue(ElementIdentifier elementIdentifier, String element, String text) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

}
