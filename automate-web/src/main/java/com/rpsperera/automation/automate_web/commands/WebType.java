package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.Type;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebType extends WCommandBase<WebType> implements Type<WebType> {
    @Override
    @Retry
    public void type(ElementIdentifier elementIdentifier, String element, String text) throws AutomateException {
        try {
            super.getElementIdentifier(elementIdentifier, element).sendKeys(text);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.TYPE);
        }
    }

}
