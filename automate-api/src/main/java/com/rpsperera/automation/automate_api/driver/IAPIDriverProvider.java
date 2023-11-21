package com.rpsperera.automation.automate_api.driver;

import com.rpsperera.automation.automate_api.command.APIGet;

public interface IAPIDriverProvider {

    APIGet getCommand() throws Exception;

}
