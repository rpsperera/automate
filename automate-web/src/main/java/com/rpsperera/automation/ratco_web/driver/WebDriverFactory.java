package com.rpsperera.automation.ratco_web.driver;

import com.rpsperera.automation.ratcore_common.enums.Browser;

public class WebDriverFactory {

    public static DriverManager getInstance(Browser browser) throws Exception {
        switch (browser) {
            case CHROME:
                return new ChromeDriverManager();
            default:
                throw new Exception("NOT YET IMPLEMENTED");
        }
    }
}
