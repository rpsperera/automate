package com.rpsperera.automation.automate_api.command;

import com.rpsperera.automation.automate_common.command_base.InstanceProvider;
import com.rpsperera.automation.automate_common.enums.Command;

public class APIFunctionProvider extends InstanceProvider {

    private APIFunctionProvider() {
    }

    protected static <T> T provide(Command command, Class<T> tClass) throws NoSuchMethodException {
        switch (command) {
            case GET:
                return tClass.cast(new APIGet());
            default:
                throw new NoSuchMethodException();
        }
    }
}
