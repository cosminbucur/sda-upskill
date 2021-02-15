package com.sda.patterns.behavioral.observer1;

// immutable object
public class Message {

    final String messageContent;

    public Message(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
