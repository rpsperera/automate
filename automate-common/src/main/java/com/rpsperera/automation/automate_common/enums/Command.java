package com.rpsperera.automation.automate_common.enums;

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
    GET_TITLE("getTitle"),
    GET("get"),
    POST("post"),
    UPDATE("update"),
    TAKE_SCREENSHOT("TakesScreenshot"),
    SELECT_POPUP("selectPopup"),
    GET_ATTRIBUTE("getAttribute"),
    IS_SELECTED("isSelected"),
    IS_ENABLED("isEnabled"),
    IS_DISPLAYED("isDisplayed"),
    WINDOW_HANDLE("windowHandle"),
    WINDOW_HANDLES("windowHandles"),
    SWITCH_TO_WINDOW("switchToWindow");

    Command(String command) {
        this.command = command;
    }

    private final String command;

    public String getCommand() {
        return this.command;
    }
}
