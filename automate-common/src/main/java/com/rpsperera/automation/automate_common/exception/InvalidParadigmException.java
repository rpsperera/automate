package com.rpsperera.automation.automate_common.exception;

public class InvalidParadigmException extends AutomateException {

    public InvalidParadigmException() {
    }

    public InvalidParadigmException(String message) {
        super(message);
    }

    public InvalidParadigmException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidParadigmException(Throwable cause) {
        super(cause);
    }

    public InvalidParadigmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
