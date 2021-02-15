package com.sda.functional.lambda.twoparam;

public class DemoLambdaTwoParam {

    public static void main(String[] args) {
        // concatenate some strings
        TwoParam twoParam = (String one, String two) -> one.concat(two).toUpperCase();
        String result = twoParam.doSomething("paul", "ene");
        System.out.println(result);
    }
}
