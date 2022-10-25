package com.qaprosoft.carina.demo.gui.components.enums;

public enum FooterButtonLink {

    HOME("Home"),

    NEWS("News"),

    Compare("Compare"),

    Coverage("Coverage"),

    Glossary("Glossary"),

    FAQ("FAQ"),

    RSS_FEED("RSS feed"),

    YOUTUBE("Youtube"),

    FACEBOOK ("Facebook"),

    TWITTER ("Twitter"),

    INSTAGRAM ("Instagram");

    private String value;

    FooterButtonLink(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
