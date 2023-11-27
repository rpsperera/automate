package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.IsEnabled;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebIsEnabled extends WCommandBase<WebIsEnabled> implements IsEnabled<WebIsEnabled> {

    @Retry
    @Override
    public Boolean isEnabled(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            return super.getElementIdentifier(elementIdentifier, element).isEnabled();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.IS_ENABLED);
            return Boolean.FALSE;
        }
    }
}
