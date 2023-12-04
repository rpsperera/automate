package com.rpsperera.automation.automate_api.driver;

import com.rpsperera.automation.automate_api.command.APIGet;
import com.rpsperera.automation.automate_api.command.APIPost;
import com.rpsperera.automation.automate_api.command.APIUpdate;

public interface IAPIDriverProvider {

    APIGet getCommand() throws Exception;

    APIPost postCommand() throws Exception;

    APIUpdate updateCommand() throws Exception;

}
