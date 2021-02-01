package com.sda.patterns.creational.builder3;

public class BrickHouseBuilder implements HouseBuilder {

    private House house;

    public BrickHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("brick");
    }

    @Override
    public void buildStructure() {
        house.setStructure("brick");
    }

    @Override
    public void buildRoof() {
        house.setFoundation("brick");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
