package com.qaprosoft.carina.demo.gui.components.enums;

public enum HeaderLink {

    HOME("HOME"),

    NEWS("NEWS"),

    REVIEWS("REVIEWS"),

    VIDEOS("VIDEOS"),

    FEATURED("FEATURED"),

    PHONE_FINDER("PHONE FINDER"),

    DEALS("DEALS"),

    MERCH("MERCH"),

    COVERAGE("COVERAGE"),

    CONTACT("CONTACT");
    private String value;

    HeaderLink(String value){
        this.value = value;
    }

    public  String getValue() {
        return  value;
    }
}
