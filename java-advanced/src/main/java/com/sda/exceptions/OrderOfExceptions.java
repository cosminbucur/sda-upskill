package com.sda.exceptions;

public class OrderOfExceptions {

    // IllegalArgumentException > NumberFormatException
    // TIP: order
    public void handleInOrder() {
        try {
            doBusinessLogic();
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println("handle NumberFormatException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("handle IllegalArgumentException");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("handle any other thing");
        }
    }

    private void doBusinessLogic() {
        System.out.println("breakable logic");
    }
}
