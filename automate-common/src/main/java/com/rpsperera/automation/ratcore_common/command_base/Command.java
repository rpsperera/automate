package com.rpsperera.automation.ratcore_common.command_base;

import com.rpsperera.automation.ratcore_common.util.ExitHandlerFI;

public interface Command<T> {

    T exitHandler(ExitHandlerFI exitHandlerFI);
}
