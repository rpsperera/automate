package com.rpsperera.automation.automate_web.driver;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.Paradigm;
import com.rpsperera.automation.automate_common.util.Log;
import com.rpsperera.automation.automate_web.commands.WebClick;
import com.rpsperera.automation.automate_web.commands.WebCommandDriver;
import com.rpsperera.automation.automate_web.commands.WebOpen;
import com.rpsperera.automation.automate_web.commands.WebType;

public class WebDriverProvider extends WebCommandDriver implements IWebDriverProvider {

    public static WebDriverProvider getInstance() {
        WebDriverProvider webDriverProvider = new WebDriverProvider();
        Runtime.getRuntime().addShutdownHook(new Thread(webDriverProvider::close));
        return webDriverProvider;
    }

    @Override
    public void setArguments(String... arguments) {
        super.setArguments(arguments);
    }

    @Override
    @Log(command = Command.OPEN, paradigm = Paradigm.WEB)
    public WebOpen setBrowser(Browser browser) throws Exception {
        super.initDriver(browser);
        return super.open();
    }

    @Override
    @Log(command = Command.CLICK, paradigm = Paradigm.WEB)
    public WebClick getClickCommand() throws Exception {
        return super.click();
    }

    @Override
    @Log(command = Command.TYPE, paradigm = Paradigm.WEB)
    public WebType getTypeCommand() throws Exception {
        return super.type();
    }
}
