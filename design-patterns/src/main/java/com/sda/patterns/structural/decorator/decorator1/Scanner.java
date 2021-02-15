package com.sda.patterns.structural.decorator.decorator1;

public class Scanner extends RobotDecorator {

    private Robot robot;

    public Scanner(Robot robot) {
        this.robot = robot;
    }

    @Override
    public String getInfo() {
        return robot.getInfo() + ", scanner";
    }

    @Override
    protected int cost() {
        return 10 + robot.cost();
    }
}
