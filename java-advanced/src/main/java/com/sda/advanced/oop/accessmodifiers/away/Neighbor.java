package com.sda.advanced.oop.accessmodifiers.away;

import com.sda.advanced.oop.accessmodifiers.home.Parent;

public class Neighbor {

    public void hasAccessTo() {
        System.out.println("wealth from parent " + new Parent().phoneNumber);
    }

    public void noAccessTo() {
//        System.out.println("default " + new Parent().familyToilet);
//        System.out.println("protected " + new Parent().wealth);
//        System.out.println("private " + new Parent().personalClothes);
    }
}
