package com.rpsperera.automation.automate_api.driver;

import com.rpsperera.automation.automate_api.command.APICommandFacade;
import com.rpsperera.automation.automate_api.command.APIGet;
import com.rpsperera.automation.automate_api.command.APIPost;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.Paradigm;
import com.rpsperera.automation.automate_common.util.Log;

public class APIDriverProvider extends APICommandFacade implements IAPIDriverProvider {

    public static APIDriverProvider getInstance() {
        return new APIDriverProvider();
    }

    @Override
    @Log(command = Command.GET, paradigm = Paradigm.API)
    public APIGet getCommand() throws Exception {
        return super.get();
    }

    @Override
    public APIPost postCommand() throws Exception {
        return super.post();
    }


}
