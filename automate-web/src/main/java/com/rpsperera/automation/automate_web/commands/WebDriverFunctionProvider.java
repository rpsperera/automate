package com.rpsperera.automation.automate_web.commands;


import com.rpsperera.automation.automate_common.command_base.InstanceProvider;
import com.rpsperera.automation.automate_common.enums.Command;

public class WebDriverFunctionProvider extends InstanceProvider {

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
            case SELECT:
                return tClass.cast(new WebSelect());
            case IS_SELECTED:
                return tClass.cast(new WebIsSelected());
            case IS_ENABLED:
                return tClass.cast(new WebIsEnabled());
            case TAKE_SCREENSHOT:
                return tClass.cast(new WebScreenCapture());
            case SELECT_POPUP:
                return tClass.cast(new WebSelectPopup());
            case IS_DISPLAYED:
                return tClass.cast(new WebIsDisplayed());
            case GET_TITLE:
                return tClass.cast(new WebGetTitle());
            case GET_ATTRIBUTE:
                return tClass.cast(new WebGetAttribute());
            case WINDOW_HANDLE:
            case WINDOW_HANDLES:
            case SWITCH_TO_WINDOW:
                return tClass.cast(new WebSelectWindow());

            default:
                throw new NoSuchMethodException();
        }
    }
}
