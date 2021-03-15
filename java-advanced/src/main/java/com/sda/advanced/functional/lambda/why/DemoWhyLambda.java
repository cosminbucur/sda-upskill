package com.sda.advanced.functional.lambda.why;

public class DemoWhyLambda {

    public static void main(String[] args) {
        withoutLambda();
        withLambda();
    }

    private static void withoutLambda() {
        // anonymous implementation
        Cleanable cleanable = new Cleanable() {
            @Override
            public void clean() {
                System.out.println("cleaning");
            }
        };
        cleanable.clean();
    }

    private static void withLambda() {
        Cleanable cleanable = () -> System.out.println("washing");
        cleanable.clean();
    }
}
