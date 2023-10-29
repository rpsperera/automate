package com.rpsperera.automation.ratco_web.commands;

import com.rpsperera.automation.ratcore_common.command_base.Open;
import com.rpsperera.automation.ratcore_common.util.Retry;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class WebOpen extends WCommandBase<WebOpen> implements Open<WebOpen> {

    @Override
    @Retry
    public void open(String url) throws Exception {
        try {
            this.webDriver.get(url);
            this.webDriver.manage().window().maximize();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
