package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.Select;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

/**
 * Created by dasitha on 2023-11-16
 *
 * @author dasitha
 */
public class WebSelect extends WCommandBase<WebSelect> implements Select<WebSelect> {
    @Retry
    @Override
    public void select(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            /*I temporarily called the "contextClick" method, but I am not certain what method I should be calling, and I would appreciate some clarifications.*/
            Actions action = new Actions(this.webDriver).contextClick(super.getElementIdentifier(elementIdentifier, element));
            action.perform();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.CLICK);
        }
    }
}
