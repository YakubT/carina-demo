package com.qaprosoft.carina.demo.streams.models;

public class MaxDiscountOwner {

    private String storeName;

    private Supplier supplier;

    public MaxDiscountOwner() {

    }

    public MaxDiscountOwner(String storeName, Supplier supplier) {
        this.storeName = storeName;
        this.supplier = supplier;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MaxDiscountOwner)) {
            return false;
        }
        MaxDiscountOwner conv = (MaxDiscountOwner) obj;
        return this.supplier.getCustomerId() == conv.supplier.getCustomerId() &&
                this.storeName.equals(conv.storeName);
    }

    @Override
    public int hashCode() {
        return this.storeName.hashCode();
    }
}
