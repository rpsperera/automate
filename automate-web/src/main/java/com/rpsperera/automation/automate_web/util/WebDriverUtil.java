package com.rpsperera.automation.automate_web.util;

import com.rpsperera.automation.automate_common.enums.ElementIdentifier;
import com.rpsperera.automation.automate_common.exception.AutomateException;
import com.rpsperera.automation.automate_common.util.ExceptionUtils;
import org.openqa.selenium.By;

import static com.rpsperera.automation.automate_common.util.Constants.UNKNOWN_ELEMENT_IDENTIFIER;

public class WebDriverUtil {

    public static By getWebIdentifierElement(ElementIdentifier identifier, String element) throws AutomateException {
        switch (identifier) {
            case XPATH:
                return By.xpath(element);
            case ID:
                return By.id(element);
            case NAME:
                return By.name(element);
            case TAG_NAME:
                return By.tagName(element);
            case CLASSNAME:
                return By.className(element);
            case LINK_TEXT:
                return By.linkText(element);
            case CSS_SELECTOR:
                return By.cssSelector(element);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(element);
            default:
                ExceptionUtils.generateAndThrowGenericException(UNKNOWN_ELEMENT_IDENTIFIER);
        }
        return null;
    }


}
