package com.qaprosoft.carina.demo.streams.models;

import java.math.BigDecimal;

public class StorePrice {

    private int productSKU;

    private String storeTittle;

    private BigDecimal price;

    public StorePrice() {

    }

    public StorePrice(int productSKU, String storeTittle, BigDecimal price) {
        this.productSKU = productSKU;
        this.storeTittle = storeTittle;
        this.price = price;
    }

    public int getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(int productSKU) {
        this.productSKU = productSKU;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStoreTittle() {
        return storeTittle;
    }

    public void setStoreTittle(String storeTittle) {
        this.storeTittle = storeTittle;
    }
}
