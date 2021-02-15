package com.sda.patterns.structural.decorator.decorator1;

public class Thrusters extends RobotDecorator {

    private Robot robot;

    public Thrusters(Robot robot) {
        this.robot = robot;
    }

    @Override
    public String getInfo() {
        return robot.getInfo() + ", thrusters";
    }

    @Override
    protected int cost() {
        return 20 + robot.cost();
    }
}
