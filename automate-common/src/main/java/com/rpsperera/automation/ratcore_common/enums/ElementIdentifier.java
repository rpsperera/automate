package com.rpsperera.automation.ratcore_common.enums;

public enum ElementIdentifier {

    XPATH("xpath"),
    CLASSNAME("className"),
    CSS_SELECTOR("cssSelector"),
    ID("id"),
    NAME("name"),
    TAG_NAME("tagName"),
    LINK_TEXT("linkText"),
    PARTIAL_LINK_TEXT("partialLinkText");

    private final String identifier;


    ElementIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
