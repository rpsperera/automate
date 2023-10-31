package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.MetaData;
import com.rpsperera.automation.automate_common.command_base.RetryI;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.util.ExitHandlerFI;
import com.rpsperera.automation.automate_web.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WCommandBase<T> extends MetaData<T> implements RetryI<T> {

    protected WebDriver webDriver;

    protected void init() {

    }

    protected WebElement getElementIdentifier(ElementIdentifier identifier, String element) throws Exception {
        By identifierElement = WebDriverUtil.getWebIdentifierElement(identifier, element);
        return this.webDriver.findElement(identifierElement);
    }

    protected T addMetaData(String key, String value) {
        this.setMetaData(key, value);
        return (T) this;
    }

    public T setCustomRetry(int retryCount, long waitTime) {
        this.setRetry(retryCount, waitTime);
        return (T) this;
    }

    protected T withDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        return (T) this;
    }

    public T exitHandler(ExitHandlerFI exitHandlerFI) {
        super.setExitHandler(exitHandlerFI);
        return (T) this;
    }
}
