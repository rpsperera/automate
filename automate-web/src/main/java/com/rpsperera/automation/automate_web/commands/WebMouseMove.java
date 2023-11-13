package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.MouseMove;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.interactions.Actions;

public class WebMouseMove extends WCommandBase<WebMouseMove> implements MouseMove<WebMouseMove> {

    @Retry
    @Override
    public void moveMouseToElement(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            Actions action = new Actions(this.webDriver).moveToElement(super.getElementIdentifier(elementIdentifier, element));
            action.perform();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.MOUSE_MOVE);
        }
    }
}
