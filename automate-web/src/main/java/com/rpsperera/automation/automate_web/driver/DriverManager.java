package com.rpsperera.automation.automate_web.driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class DriverManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);
    protected WebDriver webDriver;

    /**
     * This would be used to get the arguments by the user.
     */
    protected List<String> arguments = new ArrayList<>();

    /**
     * Use this method to start the specific
     * web driver
     */
    protected abstract void startService();

    /**
     * Use this method create the implementation
     * to stop the driver service.
     */
    protected abstract void stopService();

    /**
     * Use this method to create the implementation
     * of the driver initiation
     * ex: chrome driver , edge driver or
     * firefox driver
     */
    protected abstract void createDriver();

    /**
     * Use this method to create the implementation
     * of the loading options to the specific web driver
     */
    protected abstract void loadArguments();

    public WebDriver getWebDriver() {
        if (Objects.isNull(this.webDriver)) {
            this.startService();
            this.createDriver();
        }
        return this.webDriver;
    }

    /**
     * Call this method to quite and end the
     * web driver session.
     */
    public void quitDriver() {
        if (Objects.nonNull(this.webDriver)) {
            try {
                this.webDriver.close();
                this.webDriver.quit();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
