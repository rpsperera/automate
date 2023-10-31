package com.rpsperera.automation.automate_web;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.enums.Paradigm;
import com.rpsperera.automation.automate_common.util.TestCase;
import com.rpsperera.automation.automate_web.driver.WebDriverProvider;

@TestCase(name = "WEBTEST", paradigm = Paradigm.WEB)
public class Main {

    public static void main(String[] args) throws Exception {

        WebDriverProvider webDriverProvider = WebDriverProvider.getInstance();
        webDriverProvider.setBrowser(Browser.CHROME).setCustomRetry(5, 200).open("https://ww.google.com");
        webDriverProvider.getClickCommand().setCustomRetry(6, 10000).click(ElementIdentifier.XPATH, "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea");
        webDriverProvider.getTypeCommand().setCustomRetry(6, 10000).type(ElementIdentifier.XPATH, "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea", "Rukshan");

        webDriverProvider.close();
    }
}
