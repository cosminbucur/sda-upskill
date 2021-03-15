package com.sda.advanced.functional.method_reference.instance_arbitrary2;

// lambda: (args) -> obj.someInstanceMethod(args)
// method reference: objectType::someInstanceMethod

import java.util.function.BiFunction;

// instance of object is used to call an instance
public class DemoInstanceArbitrary2 {

    public static void main(String[] args) {
        useLambdaExpression();
        useMethodReference();
    }

    private static void useLambdaExpression() {
        BiFunction<String, Integer, String> biFunction1 = (text, beginIndex) -> text.substring(beginIndex);
        String phone = getSubstring("+40722333444", 2, biFunction1);
        System.out.println(phone);
    }

    private static void useMethodReference() {
        BiFunction<String, Integer, String> biFunction = String::substring;
        String phone = getSubstring("+40722333444", 2, biFunction);
        System.out.println(phone);
    }

    private static String getSubstring(String text, int beginIndex, BiFunction<String, Integer, String> biFunction) {
        return biFunction.apply(text, beginIndex);
    }
}
