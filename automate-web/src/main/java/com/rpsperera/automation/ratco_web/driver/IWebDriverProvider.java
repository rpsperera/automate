package com.rpsperera.automation.ratco_web.driver;

import com.rpsperera.automation.ratco_web.commands.WebClick;
import com.rpsperera.automation.ratco_web.commands.WebOpen;
import com.rpsperera.automation.ratco_web.commands.WebType;
import com.rpsperera.automation.ratcore_common.enums.Browser;

public interface IWebDriverProvider {

    void setArguments(String... arguments);

    WebOpen setBrowser(Browser browser) throws Exception;

    WebClick getClickCommand() throws Exception;

    WebType getTypeCommand() throws Exception;
}
