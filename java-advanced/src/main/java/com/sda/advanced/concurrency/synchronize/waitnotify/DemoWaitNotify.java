package com.sda.advanced.concurrency.synchronize.waitnotify;

// https://www.baeldung.com/java-wait-notify
public class DemoWaitNotify {

    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
