package com.sda.advanced.concurrency.synchronize.waitnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {

    private Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (String receivedMessage = data.receive();
             !"finish".equals(receivedMessage);
             receivedMessage = data.receive()) {

            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
    }
}

