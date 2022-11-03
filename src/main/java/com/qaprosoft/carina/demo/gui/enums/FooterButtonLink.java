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

    GSMARENACOM ("GSMArena.com"),

    MOBILE_VERSION("Mobile version"),

    ANDROID_APP ("Android app"),

    TOOLS ("Tools"),

    CONTACT_US ("Contact us"),

    MERCH_STORE ("Merch store"),

    PRIVACY("Privacy"),

    TERMS_OF_USE("Terms of use"),

    HOME("Home");

    private String value;

    FooterButtonLink(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
