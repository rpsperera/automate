package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.util.ExitHandlerFI;
import com.rpsperera.automation.automate_common.util.PropertyFileReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static com.rpsperera.automation.automate_common.util.Constants.RETRY_COUNT;
import static com.rpsperera.automation.automate_common.util.Constants.WAIT_TIME;

public abstract class MetaData<T> {

    public Map<String, Object> metaData;

    public ExitHandlerFI exitHandler;

    protected MetaData() {
        this.metaData = new HashMap<>();
        AtomicReference<Integer> retryCount = new AtomicReference<>();
        AtomicReference<Long> waitTime = new AtomicReference<>();
        Optional.ofNullable(PropertyFileReader.INSTANCE.getProperties().getProperty(RETRY_COUNT)).ifPresentOrElse(ret -> retryCount.set(Integer.parseInt(ret)), () -> retryCount.set(3));
        Optional.ofNullable(PropertyFileReader.INSTANCE.getProperties().getProperty(WAIT_TIME)).ifPresentOrElse(ret -> waitTime.set(Long.parseLong(ret)), () -> waitTime.set(500L));
        this.setRetry(retryCount.get(), waitTime.get());

    }

    protected abstract T addMetaData(String key, String value);

    protected void setRetry(int retryCount, long waitTime) {
        this.metaData.put(RETRY_COUNT, retryCount);
        this.metaData.put(WAIT_TIME, waitTime);
    }

    protected void setMetaData(String key, String value) {
        this.metaData.put(key, value);
    }

    public void setExitHandler(ExitHandlerFI handler) {
        this.exitHandler = handler;
    }


}
