package com.qaprosoft.carina.demo.streams.models;

public class Entrant {

    private int schoolNumber;

    private int yearOfEntering;

    private String lastName;

    public Entrant() {

    }

    public Entrant(int schoolNumber, int yearOfEntering, String lastName) {
        this.schoolNumber = schoolNumber;
        this.yearOfEntering = yearOfEntering;
        this.lastName = lastName;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public int getYearOfEntering() {
        return yearOfEntering;
    }

    public void setYearOfEntering(int yearOfEntering) {
        this.yearOfEntering = yearOfEntering;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
