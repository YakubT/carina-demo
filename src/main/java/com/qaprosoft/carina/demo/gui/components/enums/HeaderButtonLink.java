package com.qaprosoft.carina.demo.gui.components.enums;

public enum HeaderButtonLink {

    NEWS("News"),

    REVIEWS("Reviews"),

    VIDEOS("Videos"),

    FEATURED("Featured"),

    PHONE_FINDER("Phone Finder"),

    DEALS("Deals"),

    MERCH("Merch"),

    COVERAGE("Coverage"),

    CONTACT("Contact"),

    HOME("Home");
    private String value;

    HeaderButtonLink(String value){
        this.value = value;
    }

    public  String getValue() {
        return  value;
    }
}
