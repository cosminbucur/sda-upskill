package com.sda.advanced.functional.interfaces.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The Predicate functional interface is a specialization of a Function that
 * receives a generified value and returns a boolean. A typical use case
 * of the Predicate lambda is to filter a collection of values
 */
public class DemoPredicates {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

        Predicate<String> startsWithAPredicate = name -> name.startsWith("A");
        Predicate<String> startsWithBPredicate = name -> name.startsWith("B");

        List<String> namesWithA = filterNames(names, startsWithAPredicate);
        List<String> namesWithB = filterNames(names, startsWithBPredicate);

        System.out.println("names with A:");
        namesWithA.forEach(System.out::println);
        System.out.println("names with A:");
        namesWithB.forEach(System.out::println);
    }

    private static List<String> filterNames(List<String> list, Predicate<String> predicate) {
        return list.stream().filter(predicate)
                .collect(Collectors.toList());
    }
}
