package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.enums.Command;

public abstract class InstanceProvider {

    protected static <T> T provide(Command command, Class<T> tClass) throws NoSuchMethodException {
        return null;
    }
}
