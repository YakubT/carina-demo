package com.qaprosoft.carina.demo.gui.components.enums;

public enum HeaderIconLink {

    TIPS("head-icon icon-tip-us icomoon-liga"),

    YOUTUBE("head-icon icon-soc-youtube icomoon-liga"),

    INSTAGRAM ("head-icon icon-instagram icomoon-liga"),

    RSS("head-icon icon-soc-rss2 icomoon-liga"),

    EV("head-icon icon-specs-car icomoon-liga"),

    MERCH("head-icon icon-cart icomoon-liga"),

    LOG_IN("login-icon"),

    SIGN_UP("signup-icon no-margin-right");


    private String value;

    HeaderIconLink(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
