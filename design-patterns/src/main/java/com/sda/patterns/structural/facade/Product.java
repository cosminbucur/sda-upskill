package com.sda.patterns.structural.facade;

public class Product {

    public long productId;
    public String name;

    public Product() {
    }

    public Product(long productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                '}';
    }
}
