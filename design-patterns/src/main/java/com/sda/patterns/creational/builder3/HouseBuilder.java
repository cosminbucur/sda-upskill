package com.sda.patterns.creational.builder3;

public interface HouseBuilder {
    void buildFoundation();

    void buildStructure();

    void buildRoof();

    House getHouse();
}
