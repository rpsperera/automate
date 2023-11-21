package com.rpsperera.automation.automate_web.driver;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_web.commands.*;

public interface IWebDriverProvider {

    void setArguments(String... arguments);

    WebOpen setBrowser(Browser browser) throws Exception;

    WebClick getClickCommand() throws Exception;

    WebType getTypeCommand() throws Exception;

    WebCheckElementPresent getCheckElementPresentCommand() throws Exception;

    WebDoubleClick getDoubleClickCommand() throws Exception;

    WebGetObjectCount getObjectCountCommand() throws Exception;

    WebGetText getTextCommand() throws Exception;

    WebMouseMove getMouseMoveCommand() throws Exception;

    WebRightClick getRightClickCommand() throws Exception;

    WebSelectFrame getSelectFrameCommand() throws Exception;

    WebSelect getSelectCommand() throws Exception;

    WebIsSelected getIsSelectedCommand() throws Exception;
    
    WebSelectPopup getSelectPopupCommand() throws Exception;
    
    WebIsEnabled getIsEnabledCommand() throws Exception;

    WebIsDisplayed getIsDisplayedCommand() throws Exception;

}
