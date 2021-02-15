package com.sda.patterns.behavioral.observer;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    void setPrice(Observer observer, int newPrice);
}
