package com.sda.functional.streams.parallel;

import java.util.stream.IntStream;

public class DemoParallelStream {

    public static void main(String[] args) {
        regularStream();
        parallelStream();
    }

    private static void regularStream() {
        IntStream stream = IntStream.rangeClosed(1, 10);
        System.out.println("Regular stream, is parallel = " + stream.isParallel());
        stream.forEach(System.out::println);
    }

    private static void parallelStream() {
        IntStream stream = IntStream.rangeClosed(1, 10).parallel();
        System.out.println("Parallel stream, is parallel = " + stream.isParallel());
        stream.forEach(System.out::println);
    }
}
