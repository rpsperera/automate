package com.rpsperera.automation.automate_common.enums;

public enum Paradigm {

    WEB("web");

    Paradigm(String paradigm) {
        this.paradigm = paradigm;
    }

    private final String paradigm;

    public String getParadigm() {
        return paradigm;
    }
}
