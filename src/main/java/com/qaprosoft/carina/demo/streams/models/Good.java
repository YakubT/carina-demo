package com.qaprosoft.carina.demo.streams.models;

public class Good {

    private int productSKU;

    private String name;

    private String countryOfOrigin;

    public Good() {

    }

    public Good(int productSKU, String name, String countryOfOrigin) {
        this.name = name;
        this.productSKU = productSKU;
        this.countryOfOrigin = countryOfOrigin;
    }

    public int getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(int productSKU) {
        this.productSKU = productSKU;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
