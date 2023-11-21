package com.rpsperera.automation.automate_web.commands;

import com.rpsperera.automation.automate_common.command_base.TakesScreenshot;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

/**
 * Created by Dilshan on 11/21/2023
 *
 * @author Dilshan Boteju
 */
public class WebIsScreenShot extends WCommandBase<WebIsScreenShot> implements TakesScreenshot<WebIsScreenShot> {

    protected WebDriver webDriver;

    @Retry
    @Override
    public File takesScreenshot(String fileName) throws AutomateException {
        // Creating instance of File
        // Take a screenshot
        File screenshotFile = ((TakesScreenshot) webDriver).takesScreenshot(fileName);
        try {
            Files.copy(screenshotFile.toPath(), new File(fileName + ".png").toPath());
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.TAKE_SCREENSHOT);
        }
        return screenshotFile;
    }
}
