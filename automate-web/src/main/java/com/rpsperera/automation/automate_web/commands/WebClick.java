package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.Click;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebClick extends WCommandBase<WebClick> implements Click<WebClick> {

    @Override
    @Retry
    public void click(ElementIdentifier elementIdentifier, String element) throws Exception {
        try {
            super.getElementIdentifier(elementIdentifier, element).click();
        } catch (Exception e) {
            throw new Exception(String.format("Unable to perform %s::%s ", Command.CLICK, e.getMessage()));
        }
    }


}
