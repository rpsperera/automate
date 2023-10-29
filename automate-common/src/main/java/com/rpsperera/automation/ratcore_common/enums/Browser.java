package com.rpsperera.automation.ratcore_common.enums;

public enum Browser {

    CHROME("chrome");

    Browser(String browser) {
        this.browser = browser;
    }

    private final String browser;

    public String getBrowser() {
        return browser;
    }
}
