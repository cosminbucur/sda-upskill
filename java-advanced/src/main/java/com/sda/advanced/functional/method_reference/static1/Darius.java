package com.sda.advanced.functional.method_reference.static1;

public class Darius {

    static int hp = 100;

    public static int dealDamage(int attackDame, int trueDamage) {
        return attackDame + trueDamage;
    }

    public static int healUp(int amount) {
        return hp += amount;
    }
}
