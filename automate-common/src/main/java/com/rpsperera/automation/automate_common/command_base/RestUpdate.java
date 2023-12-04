package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.dto.ResponseDTO;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.exception.InvalidParadigmException;
import com.rpsperera.automation.automate_common.util.Constants;

import java.security.SecureRandom;

public interface RestUpdate<T> extends Command<T> {

    default ResponseDTO update() throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO update(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO update(String username, String password) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO updateForSelfSignedCerts(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
}
