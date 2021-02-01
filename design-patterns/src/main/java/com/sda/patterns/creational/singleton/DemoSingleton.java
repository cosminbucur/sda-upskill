package com.sda.patterns.creational.singleton;

public class DemoSingleton {

    public static void main(String[] args) {
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();
        StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();
        LazyInitializedSingleton lazyInitializedSingleton = LazyInitializedSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton2 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
    }
}
