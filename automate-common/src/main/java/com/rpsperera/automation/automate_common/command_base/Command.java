package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.util.ExitHandlerFI;

public interface Command<T> {

    T exitHandler(ExitHandlerFI exitHandlerFI);
}
