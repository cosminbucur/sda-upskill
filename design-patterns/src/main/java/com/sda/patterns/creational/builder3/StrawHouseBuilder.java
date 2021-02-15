package com.sda.patterns.creational.builder3;

public class StrawHouseBuilder implements HouseBuilder {

    private House house;

    public StrawHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("straw");
    }

    @Override
    public void buildStructure() {
        house.setStructure("straw");
    }

    @Override
    public void buildRoof() {
        house.setRoof("straw");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
