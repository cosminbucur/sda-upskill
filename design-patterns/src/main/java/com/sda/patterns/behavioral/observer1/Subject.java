package com.sda.patterns.behavioral.observer1;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyUpdate(Message message);
}
