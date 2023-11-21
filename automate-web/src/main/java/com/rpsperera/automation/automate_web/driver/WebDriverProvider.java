package com.rpsperera.automation.automate_web.driver;

import com.rpsperera.automation.automate_common.enums.Browser;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.enums.Paradigm;
import com.rpsperera.automation.automate_common.util.Log;
import com.rpsperera.automation.automate_web.commands.*;

public class WebDriverProvider extends WebCommandFacade implements IWebDriverProvider {

    public static WebDriverProvider getInstance() {
        WebDriverProvider webDriverProvider = new WebDriverProvider();
        Runtime.getRuntime().addShutdownHook(new Thread(webDriverProvider::close));
        return webDriverProvider;
    }

    @Override
    public void setArguments(String... arguments) {
        super.setArguments(arguments);
    }

    @Override
    @Log(command = Command.OPEN, paradigm = Paradigm.WEB)
    public WebOpen setBrowser(Browser browser) throws Exception {
        super.initDriver(browser);
        return super.open();
    }

    @Override
    @Log(command = Command.CLICK, paradigm = Paradigm.WEB)
    public WebClick getClickCommand() throws Exception {
        return super.click();
    }

    @Override
    @Log(command = Command.CHECK_ELEMENT_PRESENT, paradigm = Paradigm.WEB)
    public WebCheckElementPresent getCheckElementPresentCommand() throws Exception {
        return super.checkElementPresent();
    }

    @Override
    @Log(command = Command.DOUBLE_CLICK, paradigm = Paradigm.WEB)
    public WebDoubleClick getDoubleClickCommand() throws Exception {
        return super.doubleClick();
    }

    @Override
    @Log(command = Command.GET_OBJECT_COUNT, paradigm = Paradigm.WEB)
    public WebGetObjectCount getObjectCountCommand() throws Exception {
        return super.getObjectCount();
    }

    @Override
    @Log(command = Command.GET_TEXT, paradigm = Paradigm.WEB)
    public WebGetText getTextCommand() throws Exception {
        return super.getText();
    }

    @Override
    @Log(command = Command.MOUSE_MOVE, paradigm = Paradigm.WEB)
    public WebMouseMove getMouseMoveCommand() throws Exception {
        return super.mouseMove();
    }

    @Override
    @Log(command = Command.RIGHT_CLICK, paradigm = Paradigm.WEB)
    public WebRightClick getRightClickCommand() throws Exception {
        return super.rightClick();
    }

    @Override
    @Log(command = Command.SELECT_FRAME, paradigm = Paradigm.WEB)
    public WebSelectFrame getSelectFrameCommand() throws Exception {
        return super.selectFrame();
    }

    @Override
    @Log(command = Command.SELECT, paradigm = Paradigm.WEB)
    public WebSelect getSelectCommand() throws Exception {
        return super.select();
    }

    @Override
    @Log(command = Command.IS_SELECTED, paradigm = Paradigm.WEB)
    public WebIsSelected getISSelectedCommand() throws Exception {
        return super.isSelected();
    }

    @Override
    @Log(command = Command.IS_ENABLED, paradigm = Paradigm.WEB)
    public WebIsEnabled getISEnabledCommand() throws Exception {
        return super.isEnabled();
    }

    @Override
    @Log(command = Command.TAKE_SCREENSHOT, paradigm = Paradigm.WEB)
    public WebIsScreenShot getISTakeScreenShotCommand() throws Exception {
        return super.takesScreenshot();
    }

    @Override
    @Log(command = Command.TYPE, paradigm = Paradigm.WEB)
    public WebType getTypeCommand() throws Exception {
        return super.type();
    }
}
