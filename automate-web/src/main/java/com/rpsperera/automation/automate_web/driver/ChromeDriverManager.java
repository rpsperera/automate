package com.rpsperera.automation.automate_web.driver;

import com.rpsperera.automation.ratcore_common.util.Constants;
import com.rpsperera.automation.ratcore_common.util.PropertyFileReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Objects;

public class ChromeDriverManager extends DriverManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChromeDriverManager.class);

    private ChromeDriverService chromeDriverService;

    private ChromeOptions options;

    @Override
    protected void startService() {
        if (Objects.isNull(this.chromeDriverService)) {
            try {
                String driverPath = PropertyFileReader.INSTANCE.getProperties().getProperty(Constants.CHROME_DRIVER_PATH);
                if (Objects.isNull(driverPath)) throw new RuntimeException();
                this.chromeDriverService = new ChromeDriverService.Builder().usingDriverExecutable(new File(driverPath)).usingAnyFreePort().build();
                this.chromeDriverService.start();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Override
    protected void stopService() {
        if (Objects.nonNull(this.chromeDriverService)) {
            this.chromeDriverService.stop();
        }
    }

    @Override
    protected void createDriver() {
        this.loadArguments();
        if (Objects.nonNull(super.arguments) && !super.arguments.isEmpty()) {
            this.webDriver = new ChromeDriver(this.chromeDriverService, this.options);
            return;
        }
        this.webDriver = new ChromeDriver(this.chromeDriverService);
    }

    @Override
    protected void loadArguments() {
        if (Objects.nonNull(super.arguments) && !super.arguments.isEmpty()) {
            this.options = new ChromeOptions();
            this.arguments.forEach(this.options::addArguments);
        }
    }
}
