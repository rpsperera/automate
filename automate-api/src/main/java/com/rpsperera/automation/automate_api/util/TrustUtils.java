package com.rpsperera.automation.automate_api.util;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Objects;
import java.util.Optional;

public class TrustUtils {

    private TrustUtils() {

    }

    public static KeyManager[] getKeyManagers(String certPath, String certProtocol, String password) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (Objects.nonNull(certPath)) {

            Path truststorePath = Optional.ofNullable(Paths.get(certPath)).orElseThrow(() -> new InvalidPathException("Given Certificate Path cannot be found ", certPath));

            try (InputStream stream = Files.newInputStream(truststorePath, StandardOpenOption.READ)) {
                KeyStore identity = KeyStore.getInstance(Optional.ofNullable(certProtocol).orElse("PKCS12"));
                identity.load(stream, password.toCharArray());
                KeyManagerFactory keyManagerFactoryAlgorithm = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactoryAlgorithm.init(identity, password.toCharArray());
                return keyManagerFactoryAlgorithm.getKeyManagers();
            }
        }
        return null;
    }
}
