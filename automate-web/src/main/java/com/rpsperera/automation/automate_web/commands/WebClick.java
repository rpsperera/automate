package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.Click;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebClick extends WCommandBase<WebClick> implements Click<WebClick> {

    @Override
    @Retry
    public void click(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            super.getElementIdentifier(elementIdentifier, element).click();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.CLICK);
        }
    }


}
