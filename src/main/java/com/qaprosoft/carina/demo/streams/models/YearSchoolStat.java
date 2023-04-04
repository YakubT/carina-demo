package com.qaprosoft.carina.demo.streams.models;

public class YearSchoolStat {

    private int yearOfEntering;

    private int numberOfSchools;

    public YearSchoolStat() {

    }

    public YearSchoolStat(int yearOfEntering, int numberOfSchools) {
        this.yearOfEntering = yearOfEntering;
        this.numberOfSchools = numberOfSchools;
    }

    public int getYearOfEntering() {
        return yearOfEntering;
    }

    public void setYearOfEntering(int yearOfEntering) {
        this.yearOfEntering = yearOfEntering;
    }

    public int getNumberOfSchools() {
        return numberOfSchools;
    }

    public void setNumberOfSchools(int numberOfSchools) {
        this.numberOfSchools = numberOfSchools;
    }

    @Override
    public boolean equals(Object a) {
        if (!(a instanceof YearSchoolStat)) {
            return false;
        }
        return this.yearOfEntering == ((YearSchoolStat) a).getYearOfEntering()
                && this.numberOfSchools == ((YearSchoolStat) a).getNumberOfSchools();
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(this.yearOfEntering).hashCode();
    }
}
