package com.sda.advanced.functional.method_reference.static2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class Numbers {

    public static boolean sumGreaterThan100(int first, int second) {
        return (first + second) > 50;
    }

    public static List<Integer> findNumbers(
            List<Integer> list, BiPredicate<Integer, Integer> predicate
    ) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            if (predicate.test(number, number + 10)) {
                result.add(number);
            }
        }
        return result;
    }
}
