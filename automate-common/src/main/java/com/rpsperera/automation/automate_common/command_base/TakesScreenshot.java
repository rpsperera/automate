package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.exception.InvalidParadigmException;

import java.io.File;

import static com.rpsperera.automation.automate_common.util.Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM;

/**
 * Created by Dilshan on 11/21/2023
 *
 * @author Dilshan Boteju
 */
public interface TakesScreenshot<T> extends Command<T> {
    default File takesScreenshot(String FileName) throws AutomateException {
        throw new InvalidParadigmException(COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
}
