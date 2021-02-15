package com.sda.patterns.behavioral.observer1;

public class SubscriberOne implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("subscriber 1: " + message.getMessageContent());
    }
}
