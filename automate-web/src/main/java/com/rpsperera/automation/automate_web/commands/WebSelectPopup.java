package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.SelectPopup;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.Alert;

public class WebSelectPopup extends WCommandBase<WebSelectPopup> implements SelectPopup<WebSelectPopup>  {
    @Retry
    @Override
    public Alert selectPop() throws AutomateException {
        try {
            return this.webDriver.switchTo().alert();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_POPUP);
        }
        return null;
    }
	@Retry
    @Override
    public void acceptPopup() throws AutomateException {
        try {
            this.webDriver.switchTo().alert().accept();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_POPUP);
        }
    }
    @Retry
    @Override
    public void dismissPopup() throws AutomateException {
        try {
            this.webDriver.switchTo().alert().dismiss();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_POPUP);
        }
    }
    @Retry
    @Override
    public String getTextPopup() throws AutomateException {
        try {
            return this.webDriver.switchTo().alert().getText();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_POPUP);
        }
        return "";
    }
    @Retry
    @Override
    public void sendKeysPopup(String stringToSend) throws AutomateException {
        try {
            this.webDriver.switchTo().alert().sendKeys(stringToSend);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_POPUP);
        }
    }

}
