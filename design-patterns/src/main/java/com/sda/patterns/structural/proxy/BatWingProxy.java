package com.sda.patterns.structural.proxy;

public class BatWingProxy implements AirShip {

    private Pilot pilot;
    private AirShip airShip;

    public BatWingProxy(Pilot pilot) {
        this.pilot = pilot;
        this.airShip = new BatWing();
    }

    @Override
    public boolean isFlyable() {
        if (pilot.getName().equals("Batman")) {
            return airShip.isFlyable();
        } else {
            System.out.println("spaceship operable only by " + pilot.getName());
            return false;
        }
    }
}
