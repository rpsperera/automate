package com.rpsperera.automation.automate_common.enums;

public enum Command {

    OPEN("open"),
    CLICK("click"),
    TYPE("type");

    Command(String command) {
        this.command = command;
    }

    private final String command;

    public String getCommand() {
        return this.command;
    }
}
