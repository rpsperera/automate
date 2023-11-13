package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.CheckElementPresent;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebCheckElementPresent extends WCommandBase<WebCheckElementPresent> implements CheckElementPresent<WebCheckElementPresent> {

    @Retry(returnsBoolean = true)
    @Override
    public boolean checkElementPresent(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            if (super.getElementIdentifier(elementIdentifier, element).isDisplayed())
                ExceptionUtils.generateAndThrowGenericException("Unable To Identify Specified Element");
            return true;
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.CHECK_ELEMENT_PRESENT);
        }
        return true;
    }
}
