package com.rpsperera.automation.automate_api.command;

import com.rpsperera.automation.automate_common.enums.Command;

public class APICommandFacade {

    protected APIGet get() throws NoSuchMethodException {
        return APIFunctionProvider.provide(Command.GET, APIGet.class);
    }

    protected APIPost post() throws NoSuchMethodException {
        return APIFunctionProvider.provide(Command.POST, APIPost.class);
    }

    protected APIUpdate update() throws NoSuchMethodException {
        return APIFunctionProvider.provide(Command.UPDATE, APIUpdate.class);
    }
    protected APIDelete delete() throws NoSuchMethodException {
        return APIFunctionProvider.provide(Command.DELETE, APIDelete.class);
    }

}
