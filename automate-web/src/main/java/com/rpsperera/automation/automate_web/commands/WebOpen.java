package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.Open;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class WebOpen extends WCommandBase<WebOpen> implements Open<WebOpen> {
    @Override
    @Retry
    public void open(String url) throws AutomateException {
        try {
            this.webDriver.get(url);
            this.webDriver.manage().window().maximize();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.OPEN);
        }
    }
}
