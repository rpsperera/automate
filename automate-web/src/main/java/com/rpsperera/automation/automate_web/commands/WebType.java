package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.Type;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebType extends WCommandBase<WebType> implements Type<WebType> {

    @Override
    @Retry
    public void type(ElementIdentifier elementIdentifier, String element, String text) throws Exception {
        try {
            super.getElementIdentifier(elementIdentifier, element).sendKeys(text);
        } catch (Exception e) {
            throw new Exception(String.format("Unable to perform %s::%s", Command.TYPE, e.getMessage()));
        }
    }

}
