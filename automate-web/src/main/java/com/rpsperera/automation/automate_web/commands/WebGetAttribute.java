package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.GetAttribute;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebGetAttribute extends WCommandBase<WebGetAttribute> implements GetAttribute<WebGetAttribute> {

    @Retry
    @Override
    public String getAttribute(ElementIdentifier elementIdentifier, String element, String attribute) throws AutomateException {
        try {
            return super.getElementIdentifier(elementIdentifier, element).getAttribute(attribute);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.GET_ATTRIBUTE);
        }
        return null;
    }
}
