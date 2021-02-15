package com.sda.functional.method_reference.static1;

import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoStaticMethod {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> realDamage = Darius::dealDamage;
        Integer result = realDamage.apply(100, 40);
        System.out.println(result);

        Function<Integer, Integer> healUp = Darius::healUp;
        Integer newHp = healUp.apply(20);
        System.out.println(newHp);
    }
}

