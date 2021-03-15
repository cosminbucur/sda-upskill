package com.sda.advanced.functional.streams.how;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-how-to-sort-a-map/
public class DemoSortMapByKeys {

    public static void main(String[] argv) {
        Map<String, Integer> map = new HashMap<>();
        map.put("z", 10);
        map.put("b", 5);
        map.put("a", 6);
        map.put("c", 20);

        System.out.println("Initial...");
        System.out.println(map);

        Map<String, Integer> sortedByKeys = sortMapByKeys(map);
        System.out.println("Sorted by keys...");
        System.out.println(sortedByKeys);

        Map<String, Integer> sortedByValues1 = sortMapByValuesReversed1(map);
        System.out.println("Sorted by values descending 1...");
        System.out.println(sortedByValues1);

        Map<String, Integer> sortedByValues2 = sortMapByValuesReversed2(map);
        System.out.println("Sorted by values descending 2...");
        System.out.println(sortedByValues2);
    }

    private static Map<String, Integer> sortMapByKeys(Map<String, Integer> map) {
        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private static Map<String, Integer> sortMapByValuesReversed1(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private static Map<String, Integer> sortMapByValuesReversed2(Map<String, Integer> map) {
        Map<String, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> result.put(entry.getKey(), entry.getValue()));
        return result;
    }

}
