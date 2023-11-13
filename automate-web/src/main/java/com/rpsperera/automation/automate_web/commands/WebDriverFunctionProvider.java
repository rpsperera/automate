package com.rpsperera.automation.automate_web.commands;


import com.rpsperera.automation.automate_common.enums.Command;

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
            case GET_TEXT:
                return tClass.cast(new WebGetText());
            case MOUSE_MOVE:
                return tClass.cast(new WebMouseMove());
            case RIGHT_CLICK:
                return tClass.cast(new WebRightClick());
            case DOUBLE_CLICK:
                return tClass.cast(new WebDoubleClick());
            case SELECT_FRAME:
                return tClass.cast(new WebSelectFrame());
            case GET_OBJECT_COUNT:
                return tClass.cast(new WebGetObjectCount());
            case CHECK_ELEMENT_PRESENT:
                return tClass.cast(new WebCheckElementPresent());
            default:
                throw new NoSuchMethodException();
        }
    }
}
