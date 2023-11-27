package com.rpsperera.automation.automate_api.driver;

import com.rpsperera.automation.automate_api.command.APIGet;
import com.rpsperera.automation.automate_api.command.APIPost;

public interface IAPIDriverProvider {

    APIGet getCommand() throws Exception;

    APIPost postCommand() throws Exception;

}
