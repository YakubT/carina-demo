package com.qaprosoft.carina.demo.streams.models;

public class Supplier {

    private int customerId;

    private int yearOfBirth;

    private String streetOfResidence;

    public Supplier() {

    }

    public Supplier(int customerId, int yearOfBirth, String streetOfResidence) {
        this.customerId = customerId;
        this.yearOfBirth = yearOfBirth;
        this.streetOfResidence = streetOfResidence;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getStreetOfResidence() {
        return streetOfResidence;
    }

    public void setStreetOfResidence(String streetOfResidence) {
        this.streetOfResidence = streetOfResidence;
    }
}
