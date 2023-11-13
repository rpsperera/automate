package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.GetObjectCount;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;

import java.util.ArrayList;
import java.util.Optional;

public class WebGetObjectCount extends WCommandBase<WebGetObjectCount> implements GetObjectCount<WebGetObjectCount> {

    @Retry
    @Override
    public int getObjectCount(ElementIdentifier elementIdentifier, String element) throws AutomateException {
        try {
            return Optional.ofNullable(super.getElements(elementIdentifier, element)).orElse(new ArrayList<>()).size();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.GET_OBJECT_COUNT);
        }
        return 0;
    }
}
