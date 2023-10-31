package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_web.driver.DriverManager;
import com.rpsperera.automation.automate_web.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public abstract class WebCommandDriver implements AutoCloseable {

    protected DriverManager driverManager = null;
    protected WebDriver webDriver = null;
    protected String[] arguments = {};

    protected void setArguments(String... arguments) {
        this.arguments = arguments;
    }

    protected void initDriver(Browser browser) throws Exception {
        if (Objects.isNull(this.driverManager)) {
            this.driverManager = WebDriverFactory.getInstance(browser);
        }
        if (Objects.isNull(this.webDriver)) {
            this.webDriver = this.driverManager.getWebDriver();
        }
    }

    protected WebOpen open() throws Exception {
        return WebDriverFunctionProvider.provide(Command.OPEN, WebOpen.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebClick click() throws Exception {
        return WebDriverFunctionProvider.provide(Command.CLICK, WebClick.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebType type() throws Exception {
        return WebDriverFunctionProvider.provide(Command.TYPE, WebType.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    @Override
    public void close() {
        if (Objects.nonNull(this.driverManager)) {
            this.driverManager.quitDriver();
        }
    }
}
