package com.sda.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String name;
    private int price;
    private Observer observer;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void setPrice(Observer observer, int newPrice) {
        int diff = price - newPrice;
        if (diff < 0) {
            this.observer = observer;
            this.price = newPrice;
            notifyObservers();
        } else {
            System.out.println("price not changed");
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("price updated");
        observers.forEach(obs ->
                obs.update(this.observer, this.name, this.price));
    }
}
