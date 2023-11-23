package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.GetTitle;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

/**
 * Created by dasitha on 2023-11-20
 *
 * @author dasitha
 */
public class WebGetTitle extends WCommandBase<WebGetTitle> implements GetTitle<WebGetTitle> {
    @Retry
    @Override
    public String getTitle() throws AutomateException {
        try {
            return this.webDriver.getTitle();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.GET_TITLE);
        }
        return null;
    }
}
