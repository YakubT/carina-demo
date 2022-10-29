package com.qaprosoft.carina.demo.gui.enums;

public enum FooterButtonLink {

    NEWS("News"),

    REVIEWS("Reviews"),

    Compare("Compare"),

    Coverage("Coverage"),

    Glossary("Glossary"),

    FAQ("FAQ"),

    RSS_FEED("RSS feed"),

    YOUTUBE("Youtube"),

    FACEBOOK ("Facebook"),

    TWITTER ("Twitter"),

    INSTAGRAM ("Instagram"),

    HOME("Home");

    private String value;

    FooterButtonLink(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
