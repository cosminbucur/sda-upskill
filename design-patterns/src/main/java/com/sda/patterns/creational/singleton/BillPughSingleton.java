package com.sda.patterns.creational.singleton;

public class BillPughSingleton {

    private BillPughSingleton() {
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // contains the instance of the singleton class
    // when the class i loaded, the helper class is not loaded
    // only when you call getInstance it will load
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
}
