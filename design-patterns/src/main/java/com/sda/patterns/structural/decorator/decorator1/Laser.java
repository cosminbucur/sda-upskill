package com.sda.patterns.structural.decorator.decorator1;

public class Laser extends RobotDecorator {

    private Robot robot;

    public Laser(Robot robot) {
        this.robot = robot;
    }

    @Override
    public String getInfo() {
        return robot.getInfo() + ", laser";
    }

    @Override
    protected int cost() {
        return 50 + robot.cost();
    }
}
