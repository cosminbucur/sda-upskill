package com.sda.patterns.behavioral.observer1;

public class SubscriberTwo implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("subscriber 2: " + message.getMessageContent());
    }
}
