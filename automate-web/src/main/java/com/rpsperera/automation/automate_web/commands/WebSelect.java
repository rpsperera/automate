package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.SelectI;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by dasitha on 2023-11-16
 *
 * @author dasitha
 */
public class WebSelect extends WCommandBase<WebSelect> implements SelectI<WebSelect> {

    @Retry
    @Override
    public void selectByVisibleText(ElementIdentifier elementIdentifier, String element, String text) throws AutomateException {
        try {
            Select select = new Select(super.getElementIdentifier(elementIdentifier, element));
            select.selectByVisibleText(text);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT);
        }
    }

    @Override
    public void selectByIndex(ElementIdentifier elementIdentifier, String element, int index) throws AutomateException {
        try {
            Select select = new Select(super.getElementIdentifier(elementIdentifier, element));
            select.selectByIndex(index);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT);
        }
    }

    @Override
    public void selectByValue(ElementIdentifier elementIdentifier, String element, String text) throws AutomateException {
        try {
            Select select = new Select(super.getElementIdentifier(elementIdentifier, element));
            select.selectByValue(text);
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT);
        }
    }
}
