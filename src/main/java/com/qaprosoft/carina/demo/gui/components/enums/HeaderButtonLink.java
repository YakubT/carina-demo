package com.qaprosoft.carina.demo.gui.components.enums;

public enum HeaderButtonLink {

    HOME("Home"),

    NEWS("News"),

    REVIEWS("Reviews"),

    VIDEOS("Videos"),

    FEATURED("Featured"),

    PHONE_FINDER("Phone finder"),

    DEALS("Deals"),

    MERCH("\"Merch\""),

    COVERAGE("Coverage"),

    CONTACT("Contact");
    private String value;

    HeaderButtonLink(String value){
        this.value = value;
    }

    public  String getValue() {
        return  value;
    }
}
