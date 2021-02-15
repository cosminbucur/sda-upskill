package com.sda.oop.enums;

public class RealEnum {

    public static void main(String[] args) {
        Hero archer = new Hero(500, Role.ARCHER);
        Hero fighter = new Hero(800, Role.FIGHTER);
        Hero assassin = new Hero(200, Role.ASSASSIN);

        System.out.println(archer.getRole());

        System.out.println(Role.ARCHER.name());

        System.out.println(archer.getRole().toString());

        Hero[] heroes = {archer, fighter, assassin};

        for (Hero hero : heroes) {
            attack(hero);
        }
    }

    private static void attack(Hero hero) {
        Role role = hero.getRole();
        switch (role) {
            case ARCHER:
                System.out.println("arrow fired");
                break;
            case FIGHTER:
                System.out.println("sword slash");
                break;
            case ASSASSIN:
                System.out.println("poison released");
                break;
        }
    }
}
