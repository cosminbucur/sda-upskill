package com.sda.advanced.functional.method_reference.instance_arbitrary1;

import java.util.Arrays;
import java.util.List;

// lambda: (args) -> obj.someInstanceMethod(args)
// method reference: objectType::someInstanceMethod

// instance of object is used to call an instance
// no need for a custom object to make to comparison
public class DemoInstanceArbitrary1 {

    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(9, 5, 7, 6, 8);
        grades.stream()
                .sorted((first, second) -> first.compareTo(second))
                .forEach(grade -> System.out.println(grade));

        grades.stream()
                .sorted(Integer::compareTo)
                .forEach(System.out::println);
    }

}
