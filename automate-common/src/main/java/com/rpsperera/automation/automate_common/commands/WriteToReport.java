package com.rpsperera.automation.automate_common.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteToReport {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteToReport.class);

    public static void writeToReport(String data) {
        LOGGER.info(data);
    }
}
