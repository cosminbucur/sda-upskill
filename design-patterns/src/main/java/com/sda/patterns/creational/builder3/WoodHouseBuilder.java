package com.sda.patterns.creational.builder3;

public class WoodHouseBuilder implements HouseBuilder {

    private House house;

    public WoodHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("wood");
    }

    @Override
    public void buildStructure() {
        house.setStructure("wood");
    }

    @Override
    public void buildRoof() {
        house.setRoof("wood");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
