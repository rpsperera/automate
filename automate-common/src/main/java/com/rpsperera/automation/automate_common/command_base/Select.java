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
public interface Select<T> extends Command<T> {
    default void select(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
}
