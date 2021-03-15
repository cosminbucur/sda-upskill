package com.sda.coupling.loose;

public class Topic1 implements Topic {

    @Override
    public void understand() {
        System.out.println("got it!");
    }
}
