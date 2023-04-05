package com.qaprosoft.carina.demo.streams.models;

public class SupplierDiscount {

    private int customerId;

    private String storeName;

    private int discountPercentage;

    public SupplierDiscount() {

    }

    public SupplierDiscount(int customerId, int discountPercentage, String storeName) {
        this.customerId = customerId;
        this.discountPercentage = discountPercentage;
        this.storeName = storeName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SupplierDiscount)) {
            return false;
        }
        SupplierDiscount conv = (SupplierDiscount) obj;
        return this.customerId == conv.customerId && this.storeName.equals(conv.storeName)
                && this.discountPercentage == conv.discountPercentage;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.customerId);
    }
}
