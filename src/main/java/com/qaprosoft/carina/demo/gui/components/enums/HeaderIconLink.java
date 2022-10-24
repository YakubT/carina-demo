package com.qaprosoft.carina.demo.gui.components.enums;

public enum HeaderIconLink {

    TIPS("Tip us"),

    YOUTUBE("1.5m"),

    INSTAGRAM ("109k"),

    RSS("RSS"),

    EV("EV"),

    MERCH("Merch"),

    LOG_IN("Log in"),

    SIGN_UP("Sign up");


    private String value;

    HeaderIconLink(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
