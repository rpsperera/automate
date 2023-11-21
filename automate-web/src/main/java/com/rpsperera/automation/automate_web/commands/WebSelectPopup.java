package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.SelectPopup;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

public class WebSelectPopup extends WCommandBase<WebSelectPopup> implements SelectPopup<WebSelectPopup>  {
	@Retry
    @Override
    public void selectPopup() throws AutomateException {
        try {;
            this.webDriver.switchTo().alert();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.SELECT_POPUP);
        }
    }

}
