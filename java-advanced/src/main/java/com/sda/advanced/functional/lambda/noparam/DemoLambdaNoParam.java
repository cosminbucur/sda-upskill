package com.sda.advanced.functional.lambda.noparam;

public class DemoLambdaNoParam {

    public static void main(String[] args) {
        // return a string
        // lambda -> (input) -> body
        // interface = implementation
        NoParam noParam = () -> "alex";
        String result = noParam.doSomething();
        System.out.println(result);
    }
}
