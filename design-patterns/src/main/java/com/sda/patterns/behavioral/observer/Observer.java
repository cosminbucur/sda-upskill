package com.sda.patterns.behavioral.observer;

public interface Observer {

    void update(Observer observer, String productName, int productPrice);

    String getEmail();
}
