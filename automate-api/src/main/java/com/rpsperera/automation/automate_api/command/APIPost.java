package com.rpsperera.automation.automate_api.command;

import com.rpsperera.automation.automate_common.command_base.RestPost;
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

public class APIPost extends APIBase<APIPost> implements RestPost<APIPost> {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIGet.class);

    @Override
    @Retry
    public ResponseDTO post() throws AutomateException {
        try {
            return this.initAndSend();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.POST);
        }
        return new ResponseDTO();
    }

    /**
     * Use this method to execute a post api with basic Authentication.
     *
     * @param username - Username to be used with basic Authentication
     * @param password - Password to be passed with basic Authentication
     * @return responseDTO after executing the api call.
     * @throws AutomateException - if the api request cannot be executed.
     */
    @Override
    @Retry
    public ResponseDTO post(String username, String password) throws AutomateException {
        try {
            this.setBasicAuth(username, password);
            return this.initAndSend();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.POST);
        }
        return new ResponseDTO();
    }

    @Override
    @Retry
    public ResponseDTO post(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        try {
            if (this.isSecure(this.url)) {
                return this.post();
            }
            super.setSSLContext(identityMaterialPath, identityProtocol, identityMaterialPassword, Optional.ofNullable(secureRandom).orElse(new SecureRandom()));
            return this.initAndSend();
        } catch (Exception e) {
            if (e.getMessage().contains("PKIX")) {
                LOGGER.warn("Unable to Verify the first certificate");
                return postForSelfSignedCerts(identityMaterialPath, identityProtocol, identityMaterialPassword, secureRandom);
            }
            ExceptionUtils.generateAndThrowCommandException(e, Command.POST);
        }
        return new ResponseDTO();
    }

    @Override
    @Retry
    public ResponseDTO postForSelfSignedCerts(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        try {
            this.reset();
            this.setSSLContextForSelfSignedCerts(identityMaterialPath, identityProtocol, identityMaterialPassword, Optional.ofNullable(secureRandom).orElse(new SecureRandom()));
            return this.initAndSend();
        } catch (Exception e) {
            ExceptionUtils.generateAndThrowCommandException(e, Command.POST);
        }
        return new ResponseDTO();
    }

    @Override
    protected ResponseDTO initAndSend() throws AutomateException, URISyntaxException, IOException, InterruptedException {
        this.init();
        HttpRequest request = this.request.POST(HttpRequest.BodyPublishers.ofString(this.body)).build();
        return this.send(request);
    }
}
