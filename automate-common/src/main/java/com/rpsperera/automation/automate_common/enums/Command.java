package com.rpsperera.automation.automate_common.enums;

import com.rpsperera.automation.automate_common.command_base.TakesScreenshot;

public enum Command {

    OPEN("open"),
    CLICK("click"),
    RIGHT_CLICK("rightClick"),
    GET_TEXT("getText"),
    SELECT_FRAME("selectFrame"),
    MOUSE_MOVE("mouseMove"),
    GET_OBJECT_COUNT("getObjectCount"),
    DOUBLE_CLICK("doubleClick"),
    TYPE("type"),
    SELECT("select"),
    CHECK_ELEMENT_PRESENT("checkElementPresent"),
    GET("get"),
    IS_SELECTED("IsSelected"),
    IS_ENABLED("IsEnabled"),
    TAKE_SCREENSHOT("TakesScreenshot");

    Command(String command) {
        this.command = command;
    }

    private final String command;

    public String getCommand() {
        return this.command;
    }
}
