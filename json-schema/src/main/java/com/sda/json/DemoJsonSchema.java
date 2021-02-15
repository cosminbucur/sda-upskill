package com.sda.json;

public class DemoJsonSchema {

    // TIP: use plugins > jsonschma2pojo:generate to generate classes
    public static void main(String[] args) {
        MyObject myObject = new MyObject(1, 20);
        myObject.getVersion();
    }
}
