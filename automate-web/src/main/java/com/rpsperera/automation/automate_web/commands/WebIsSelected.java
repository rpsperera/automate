package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.IsSelected;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebIsSelected extends WCommandBase<WebIsSelected> implements IsSelected<WebIsSelected> {

    @Retry
    @Override
    public Boolean isSelected(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            return super.getElementIdentifier(elementIdentifier, element).isSelected();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.IS_SELECTED);
            return Boolean.FALSE;
        }
    }
}
