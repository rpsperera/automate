package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_web.driver.DriverManager;
import com.rpsperera.automation.automate_web.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public abstract class WebCommandFacade implements AutoCloseable {

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

    protected WebCheckElementPresent checkElementPresent() throws Exception {
        return WebDriverFunctionProvider.provide(Command.CHECK_ELEMENT_PRESENT, WebCheckElementPresent.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebDoubleClick doubleClick() throws Exception {
        return WebDriverFunctionProvider.provide(Command.DOUBLE_CLICK, WebDoubleClick.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebGetObjectCount getObjectCount() throws Exception {
        return WebDriverFunctionProvider.provide(Command.GET_OBJECT_COUNT, WebGetObjectCount.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebGetText getText() throws Exception {
        return WebDriverFunctionProvider.provide(Command.GET_TEXT, WebGetText.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebMouseMove mouseMove() throws Exception {
        return WebDriverFunctionProvider.provide(Command.MOUSE_MOVE, WebMouseMove.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebRightClick rightClick() throws Exception {
        return WebDriverFunctionProvider.provide(Command.RIGHT_CLICK, WebRightClick.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebSelectFrame selectFrame() throws Exception {
        return WebDriverFunctionProvider.provide(Command.SELECT_FRAME, WebSelectFrame.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebSelect select() throws Exception {
        return WebDriverFunctionProvider.provide(Command.SELECT, WebSelect.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebIsSelected isSelected() throws Exception {
        return WebDriverFunctionProvider.provide(Command.IS_SELECTED, WebIsSelected.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebIsEnabled isEnabled() throws Exception {
        return WebDriverFunctionProvider.provide(Command.IS_ENABLED, WebIsEnabled.class).withDriver(this.webDriver).exitHandler(this::close);
    }

    protected WebGetAttribute getAttribute() throws Exception {
        return WebDriverFunctionProvider.provide(Command.GET_ATTRIBUTE, WebGetAttribute.class).withDriver(this.webDriver).exitHandler(this::close);
    }
    @Override
    public void close() {
        if (Objects.nonNull(this.driverManager)) {
            this.driverManager.quitDriver();
        }
    }
}
