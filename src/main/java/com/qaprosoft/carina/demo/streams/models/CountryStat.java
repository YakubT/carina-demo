package com.qaprosoft.carina.demo.streams.models;

import java.math.BigDecimal;

public class CountryStat {

    private String countryName;

    private int numberOfStores;

    private BigDecimal minPrice;

    public CountryStat() {

    }

    public CountryStat(String countryName, int numberOfStores, BigDecimal minPrice) {
        this.countryName = countryName;
        this.numberOfStores = numberOfStores;
        this.minPrice = minPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public int getNumberOfStores() {
        return numberOfStores;
    }

    public void setNumberOfStores(int numberOfStores) {
        this.numberOfStores = numberOfStores;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CountryStat) {
            CountryStat conv = (CountryStat) obj;
            return conv.minPrice.compareTo(this.minPrice) == 0 && conv.countryName.equals(this.countryName)
                    && conv.numberOfStores == this.numberOfStores;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.countryName.hashCode();
    }
}
