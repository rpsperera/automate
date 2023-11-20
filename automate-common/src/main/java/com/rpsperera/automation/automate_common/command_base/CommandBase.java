package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.util.ExitHandlerFI;

public abstract class CommandBase<T> extends MetaData<T> implements RetryI<T> {

    protected T addMetaData(String key, String value) {
        this.setMetaData(key, value);
        return (T) this;
    }

    public T setCustomRetry(int retryCount, long waitTime) {
        this.setRetry(retryCount, waitTime);
        return (T) this;
    }

    public T exitHandler(ExitHandlerFI exitHandlerFI) {
        super.setExitHandler(exitHandlerFI);
        return (T) this;
    }
}
