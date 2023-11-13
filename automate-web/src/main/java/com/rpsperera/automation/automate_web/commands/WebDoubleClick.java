package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.DoubleClick;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.interactions.Actions;

public class WebDoubleClick extends WCommandBase<WebDoubleClick> implements DoubleClick<WebDoubleClick> {

    @Retry
    @Override
    public void doubleClick(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            Actions actions = new Actions(this.webDriver).doubleClick(super.getElementIdentifier(elementIdentifier, element));
            actions.perform();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.DOUBLE_CLICK);
        }
    }
}
