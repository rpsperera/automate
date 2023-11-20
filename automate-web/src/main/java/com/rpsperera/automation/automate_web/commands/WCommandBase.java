package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.CommandBase;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_web.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class WCommandBase<T> extends CommandBase<T> {

    protected WebDriver webDriver;

    protected WebElement getElementIdentifier(ElementIdentifier identifier, String element) throws AutomateException {
        By identifierElement = WebDriverUtil.getWebIdentifierElement(identifier, element);
        return this.webDriver.findElement(identifierElement);
    }

    protected List<WebElement> getElements(ElementIdentifier identifier, String element) throws AutomateException {
        By identifierElement = WebDriverUtil.getWebIdentifierElement(identifier, element);
        return this.webDriver.findElements(identifierElement);
    }

    protected T withDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        return (T) this;
    }
}
