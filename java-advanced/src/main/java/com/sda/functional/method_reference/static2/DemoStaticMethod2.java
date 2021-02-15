package com.sda.functional.method_reference.static2;

import java.util.Arrays;
import java.util.List;

// TODO: fix this
// https://www.codementor.io/@eh3rrera/using-java-8-method-reference-du10866vx
public class DemoStaticMethod2 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6, 12, 40, 18, 33, 24, 40);

        // lambda
        Numbers.findNumbers(numbers, (first, second) -> Numbers.sumGreaterThan100(first, second));

        // method reference
        Numbers.findNumbers(numbers, Numbers::sumGreaterThan100)
                .forEach(System.out::println);
    }
}
