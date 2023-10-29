package com.rpsperera.automation.ratcore_common.command_base;

public interface RetryI<T> {

    T setCustomRetry(int retryCount, long waitTime);
}
