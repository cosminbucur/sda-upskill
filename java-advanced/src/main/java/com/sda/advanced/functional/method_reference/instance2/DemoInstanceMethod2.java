package com.sda.advanced.functional.method_reference.instance2;

import java.util.Arrays;
import java.util.List;

// instance of object is passed and calls to an instance method
public class DemoInstanceMethod2 {

    public static void main(String[] args) {
        Boat boat1 = new Boat("red", 5);
        Boat boat2 = new Boat("green", 8);
        Boat boat3 = new Boat("blue", 3);

        List<Boat> boats = Arrays.asList(boat1, boat2, boat3);

        BoatComparator comparator = new BoatComparator();

        // lambda
        boats.stream()
                .sorted((first, second) -> comparator.compare(first, second));

        // method reference
        boats.stream()
                .sorted(comparator::compare);

        // replace with qualifier
        boats.stream()
                .sorted(comparator);
    }
}
