package com.rpsperera.automation.automate_common.exception;

public class AutomateException extends Exception {

    public AutomateException() {
        super();
    }

    public AutomateException(String message) {
        super(message);
    }

    public AutomateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutomateException(Throwable cause) {
        super(cause);
    }

    protected AutomateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
