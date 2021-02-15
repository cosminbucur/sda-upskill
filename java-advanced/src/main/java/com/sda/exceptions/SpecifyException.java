package com.sda.exceptions;

public class SpecifyException {

    public void wrong() throws Exception {
        businessLogic();
    }

    // TIP: use specific classes
    public void right() throws IllegalArgumentException, IllegalStateException {
        businessLogic();
    }

    private void businessLogic() {
        System.out.println("breakable logic");
    }
}
