package com.sda.patterns.creational.builder3;

public class Pig {

    private HouseBuilder builder;

    public Pig(HouseBuilder builder) {
        this.builder = builder;
    }

    public House build() {
        this.builder.buildFoundation();
        this.builder.buildStructure();
        this.builder.buildRoof();
        return this.builder.getHouse();
    }
}
