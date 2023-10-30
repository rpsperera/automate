package com.rpsperera.automation.automate_common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public enum PropertyFileReader {

    INSTANCE;
    private static Logger LOGGER;

    public static Properties properties;

    PropertyFileReader() {
        init();
    }

    public Properties getProperties() {
        return properties;
    }

    private void init() {
        LOGGER = LoggerFactory.getLogger(PropertyFileReader.class);
        properties = new Properties();
        Optional.ofNullable(getPropertyFilePath()).ifPresent(path -> {
            try (FileReader fileReader = new FileReader(path)) {
                properties.load(fileReader);
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
    }

    private String getPropertyFilePath() {
        String filePath = getFilePath("config//application.properties", false);

        if (Objects.nonNull(filePath)) {
            return filePath;
        }

        filePath = getFilePath("..//config//application.properties", true);
        if (Objects.nonNull(filePath)) {
            return filePath;
        }

        filePath = getFilePath("application.properties", true);
        if (Objects.nonNull(filePath)) {
            return filePath;
        }

        filePath = getFilePath("config//application.properties", true);
        if (Objects.nonNull(filePath)) {
            return filePath;
        }
        return null;
    }

    private String getFilePath(String path, boolean classPath) {
        AtomicReference<String> resPath = new AtomicReference<>();
        if (classPath) {
            URL resource = PropertyFileReader.class.getClassLoader().getResource(path);
            Optional.ofNullable(resource).ifPresent(pa -> {
                try {
                    resPath.set(Paths.get(Objects.requireNonNull(pa).toURI()).toFile().getAbsolutePath());
                } catch (URISyntaxException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            });
        } else {
            File file = new File(path);
            if (file.exists()) resPath.set(file.getAbsolutePath());
        }

        return resPath.get();
    }
}
