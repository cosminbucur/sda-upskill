package com.sda.advanced.concurrency.synchronize.waitnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {

    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String[] messages = {"message 1", "message 2", "message 3", "finish"};

        for (String message : messages) {
            data.send(message);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
    }

}
