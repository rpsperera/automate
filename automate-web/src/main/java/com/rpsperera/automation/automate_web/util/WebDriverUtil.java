package com.rpsperera.automation.automate_web.util;

import com.rpsperera.automation.ratcore_common.enums.ElementIdentifier;
import org.openqa.selenium.By;

public class WebDriverUtil {

    public static By getWebIdentifierElement(ElementIdentifier identifier, String element) throws Exception {
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
                throw new Exception("Unknown Element Identifier type");
        }
    }


}
