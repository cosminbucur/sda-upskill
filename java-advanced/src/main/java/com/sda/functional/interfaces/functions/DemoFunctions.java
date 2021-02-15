package com.sda.functional.interfaces.functions;

import java.util.function.Function;

// functional interface with method apply
public class DemoFunctions {

    public static void main(String[] args) {
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return 2 * integer;
            }
        };

        Function<Integer, Integer> lambdaFunction = integer -> 2 * integer;
    }
}
