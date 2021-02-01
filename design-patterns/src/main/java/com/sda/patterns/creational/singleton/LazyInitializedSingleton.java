package com.sda.patterns.creational.singleton;

// fine for single-threaded environments
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            // can cause issues if multiple threads get here
            // both threads will get the different instances
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
