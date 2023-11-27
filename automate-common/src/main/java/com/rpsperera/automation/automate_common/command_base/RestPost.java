package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.dto.ResponseDTO;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.exception.InvalidParadigmException;
import com.rpsperera.automation.automate_common.util.Constants;

import java.security.SecureRandom;

public interface RestPost<T> extends Command<T> {

    default ResponseDTO post() throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO post(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO post(String username, String password) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO postForSelfSignedCerts(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
}
