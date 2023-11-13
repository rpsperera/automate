package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.RightClick;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.interactions.Actions;

public class WebRightClick extends WCommandBase<WebRightClick> implements RightClick<WebRightClick> {

    @Retry
    @Override
    public void rightClick(ElementIdentifier elementIdentifier, String element) throws AutomateException {

        try {
            Actions action = new Actions(this.webDriver).contextClick(super.getElementIdentifier(elementIdentifier, element));
            action.perform();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.CLICK);
        }
    }
}
