package com.sda.patterns.behavioral.observer;

public class Customer implements Observer {

    private String email;

    public Customer(String email) {
        this.email = email;
    }

    @Override
    public void update(Observer observer, String productName, int productPrice) {
        if (observer.getEmail().equals("")) {
            System.out.println("product: " + productName);
        } else {

        }
    }

    @Override
    public String getEmail() {
        return email;
    }
}
