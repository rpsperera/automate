package com.rpsperera.automation.ratco_web;

import com.rpsperera.automation.ratco_web.driver.WebDriverProvider;
import com.rpsperera.automation.ratcore_common.enums.Browser;
import com.rpsperera.automation.ratcore_common.enums.ElementIdentifier;
import com.rpsperera.automation.ratcore_common.enums.Paradigm;
import com.rpsperera.automation.ratcore_common.util.TestCase;

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
