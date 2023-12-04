package com.rpsperera.automation.automate_common.command_base;

import com.rpsperera.automation.automate_common.dto.ResponseDTO;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.exception.InvalidParadigmException;
import com.rpsperera.automation.automate_common.util.Constants;

import java.security.SecureRandom;

public interface RestDelete<T> extends Command<T> {

    default ResponseDTO delete() throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO delete(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO delete(String username, String password) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }

    default ResponseDTO deleteForSelfSignedCerts(String identityMaterialPath, String identityProtocol, String identityMaterialPassword, SecureRandom secureRandom) throws AutomateException {
        throw new InvalidParadigmException(Constants.COMMAND_NOT_IMPLEMENTED_FOR_CURRENT_PARADIGM);
    }
}
