package com.rpsperera.automation.automate_api.util;

import com.rpsperera.automation.automate_common.util.PropertyFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyStore;
import java.util.Optional;

public class TrustManagerHolder {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrustManagerHolder.class);

    private TrustManager[] trustManagers;

    private TrustManagerHolder() {
        init();
    }

    private void init() {
        //the property has to be defined or else it'll take default
        String storePath = PropertyFileReader.properties.getProperty("trust.store.path");
        // truststore type
        String trustStoreType = PropertyFileReader.properties.getProperty("trust.store.type");
        String trustStorePassword = PropertyFileReader.properties.getProperty("trust.store.password");
        String trustStoreAlgorithm = PropertyFileReader.properties.getProperty("trust.store.algorithm");

        Path truststorePath = Optional.of(Paths.get(Optional.ofNullable(storePath).orElse("configs/cacerts"))).orElseGet(() -> Paths.get("cacerts"));
        if (truststorePath.toFile().exists()) {
            try (InputStream inputStream = Files.newInputStream(truststorePath, StandardOpenOption.READ)) {
                KeyStore truststore = KeyStore.getInstance(Optional.ofNullable(trustStoreType).orElse("jks"));
                truststore.load(inputStream, Optional.ofNullable(trustStorePassword).orElse("changeit").toCharArray());
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(Optional.ofNullable(trustStoreAlgorithm).orElse(TrustManagerFactory.getDefaultAlgorithm()));
                trustManagerFactory.init(truststore);
                trustManagers = trustManagerFactory.getTrustManagers();
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    public static TrustManagerHolder getInstance() {
        return Holder.INSTANCE;
    }

    public TrustManager[] getTrustManagers() {
        return Holder.INSTANCE.trustManagers;
    }

    private static final class Holder {
        private static final TrustManagerHolder INSTANCE = new TrustManagerHolder();
    }
}
