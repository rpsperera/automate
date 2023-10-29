package com.rpsperera.automation.ratcore_common.command_base;

public interface Open<T> extends Command<T> {

    default void open(String url) throws Exception {
    }
}
