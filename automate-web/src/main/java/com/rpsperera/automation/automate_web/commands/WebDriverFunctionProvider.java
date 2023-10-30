package com.rpsperera.automation.automate_web.commands;


import com.rpsperera.automation.ratcore_common.enums.Command;

public class WebDriverFunctionProvider {

    private WebDriverFunctionProvider() {

    }

    protected static <T> T provide(Command command, Class<T> tClass) throws NoSuchMethodException {
        switch (command) {
            case OPEN:
                return tClass.cast(new WebOpen());
            case CLICK:
                return tClass.cast(new WebClick());
            case TYPE:
                return tClass.cast(new WebType());
            default:
                throw new NoSuchMethodException();
        }
    }
}
