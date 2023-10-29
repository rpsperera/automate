package com.rpsperera.automation.ratco_web.commands;

import com.rpsperera.automation.ratcore_common.command_base.Type;
import com.rpsperera.automation.ratcore_common.enums.Command;
import com.rpsperera.automation.ratcore_common.enums.ElementIdentifier;
import com.rpsperera.automation.ratcore_common.util.Retry;

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
