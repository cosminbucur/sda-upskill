package com.sda.advanced.functional.interfaces.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

// https://www.concretepage.com/java/jdk-8/java-8-unaryoperator-binaryoperator-example
public class DemoBinaryOperator {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("X", "A");
        map.put("Y", "B");
        map.put("Z", "C");
        BinaryOperator<String> binaryOperator = (key, value) -> key + "-" + value;
        List<String> keyValueStrings = useBinaryOperator(binaryOperator, map);
        keyValueStrings.forEach(element -> System.out.println(element));
    }

    private static List<String> useBinaryOperator(BinaryOperator<String> binaryOperator, Map<String, String> map) {
        List<String> result = new ArrayList<>();
        map.forEach((key, value) -> result.add(binaryOperator.apply(key, value)));
        return result;
    }
}
