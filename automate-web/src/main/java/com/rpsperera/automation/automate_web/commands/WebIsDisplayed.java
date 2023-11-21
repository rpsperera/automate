package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.IsDisplayed;
import com.rpsperera.automation.automate_common.command_base.IsEnabled;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebIsDisplayed extends WCommandBase<WebIsDisplayed> implements IsDisplayed<WebIsDisplayed> {

    @Retry
    @Override
    public Boolean isDisplayed(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            return super.getElementIdentifier(elementIdentifier, element).isDisplayed();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.IS_DISPLAYED);
            return Boolean.FALSE;
        }
    }
}
