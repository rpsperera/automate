package com.rpsperera.automation.automate_common.command_base;

public interface Open<T> extends Command<T> {

    default void open(String url) throws Exception {
    }
}
