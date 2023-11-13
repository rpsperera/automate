package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.SelectFrame;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.WebElement;

public class WebSelectFrame extends WCommandBase<WebSelectFrame> implements SelectFrame<WebSelectFrame> {

    @Retry
    @Override
    public void selectFrame(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            WebElement identifier = super.getElementIdentifier(elementIdentifier, element);
            this.webDriver.switchTo().frame(identifier);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_FRAME);
        }
    }

    @Retry
    @Override
    public void selectFrameById(int id) throws AutomateException {
        try {
            this.webDriver.switchTo().frame(id);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_FRAME);
        }
    }

    @Retry
    @Override
    public void selectFrameByNameOrId(String nameOrId) throws AutomateException {
        try {
            this.webDriver.switchTo().frame(nameOrId);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_FRAME);
        }
    }
}
