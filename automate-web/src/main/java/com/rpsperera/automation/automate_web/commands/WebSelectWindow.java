package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.SelectWindow;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by dasitha on 2023-11-20
 *
 * @author dasitha
 */
public class WebSelectWindow extends WCommandBase<WebSelectWindow> implements SelectWindow<WebSelectWindow> {
    @Retry
    @Override
    public String getWindowHandle() throws AutomateException {
        try {
            return this.webDriver.getWindowHandle();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.WINDOW_HANDLE);
        }

        return null;
    }

    @Retry
    @Override
    public Set<String> getWindowHandles() throws AutomateException {
        try {
            return this.webDriver.getWindowHandles();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.WINDOW_HANDLES);
        }

        return null;
    }

    @Retry
    @Override
    public WebDriver switchToWindow(String window) throws AutomateException {
        try {
            return this.webDriver.switchTo().window(window);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SWITCH_TO_WINDOW);
        }

        return null;
    }
}
