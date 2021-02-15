package com.sda.oop.enums;

public class DemoEnum {

    public static void main(String[] args) {
        Direction direction = Direction.EAST;

        // use enum
        if (direction.equals(Direction.EAST)) {
            System.out.println("going to China Town");
        }

        // get enum name
        String enumName = Direction.NORTH.name();  // NORTH

        String input = "NORTH";
        if (enumName.equals(input)) {
            System.out.println("going snowboarding");
        }

        // get enum value form string
        Direction enumValue = Direction.valueOf("SOUTH");
        System.out.println("enum value: " + enumValue);

        // get enum values
        Direction[] values = Direction.values();

        for (Direction item : values) {
            System.out.println(item);
        }
    }
}
