package com.rpsperera.automation.automate_common.command_base;

public interface RetryI<T> {

    T setCustomRetry(int retryCount, long waitTime);
}
