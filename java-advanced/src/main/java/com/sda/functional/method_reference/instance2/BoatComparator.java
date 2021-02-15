package com.sda.functional.method_reference.instance2;

import java.util.Comparator;

public class BoatComparator implements Comparator<Boat> {

    @Override
    public int compare(Boat first, Boat second) {
        return first.getLength().compareTo(second.getLength());
    }
}
