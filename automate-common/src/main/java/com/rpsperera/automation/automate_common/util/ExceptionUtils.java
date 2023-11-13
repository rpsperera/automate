package com.rpsperera.automation.automate_common.util;

import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.exception.AutomateException;

import static com.rpsperera.automation.automate_common.util.Constants.COMMAND_GENERAL_EXCEPTION_MESSAGE;

public class ExceptionUtils {

    private ExceptionUtils() {

    }

    public static void generateAndThrowCommandException(Exception e, Command command) throws AutomateException {
        throw new AutomateException(String.format(COMMAND_GENERAL_EXCEPTION_MESSAGE, command, e.getMessage()));
    }

    public static void generateAndThrowGenericException(String message) throws AutomateException {
        throw new AutomateException(message);
    }

}
