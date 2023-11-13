package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.GetText;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebGetText extends WCommandBase<WebGetText> implements GetText<WebGetText> {

    @Retry
    @Override
    public String getText(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            return super.getElementIdentifier(elementIdentifier, element).getText();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.GET_TEXT);
        }
        return null;
    }
}
