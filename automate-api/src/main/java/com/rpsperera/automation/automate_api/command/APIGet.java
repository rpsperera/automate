package com.rpsperera.automation.automate_api.command;

import com.rpsperera.automation.automate_common.command_base.RestGet;
import com.rpsperera.automation.automate_common.dto.ResponseDTO;
import com.rpsperera.automation.automate_common.enums.Command;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import com.rpsperera.automation.automate_common.util.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.security.SecureRandom;
import java.util.Optional;

public class APIGet extends APIBase<APIGet> implements RestGet<APIGet> {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIGet.class);

    @Override
    @Retry
    public ResponseDTO get() throws AutomateException {
        try {
            this.initAndSend();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.GET);
        }
        return new ResponseDTO();
    }

    @Override
    @Retry
    public ResponseDTO get(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        try {
            if (!this.isSecure(this.url)) {
                return this.get();
            }
            super.setSSLContext(identityMaterialPath, identityProtocol, identityMaterialPassword, Optional.ofNullable(secureRandom).orElse(new SecureRandom()));
            return this.initAndSend();
        } catch (Exception e) {

            if (e.getMessage().contains("PKIX")) {
                LOGGER.warn("Unable to Verify the first certificate");
                return getForSelfSignedCerts(identityMaterialPath, identityProtocol, identityMaterialPassword, secureRandom);
            }
            ExceptionUtils.generateAndThrowCommandException(e, Command.GET);
        }
        return new ResponseDTO();
    }

    @Override
    @Retry
    public ResponseDTO getForSelfSignedCerts(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        try {
            this.reset();
            this.setSSLContextForSelfSignedCerts(identityMaterialPath, identityProtocol, identityMaterialPassword, Optional.ofNullable(secureRandom).orElse(new SecureRandom()));
            return this.initAndSend();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.GET);
        }
        return new ResponseDTO();
    }

    private ResponseDTO initAndSend() throws AutomateException, URISyntaxException, IOException, InterruptedException {
        this.init();
        HttpRequest request = this.request.GET().build();
        return this.send(request);
    }
}
