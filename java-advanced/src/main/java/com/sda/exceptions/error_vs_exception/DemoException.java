package com.sda.exceptions.error_vs_exception;

public class DemoException {

    public static void main(String[] args) {
        Integer fakeNumber = null;
        useNullPointerException(fakeNumber);

        useArithmeticException();
    }

    private static int useNullPointerException(Integer number) {
        return number.compareTo(1);
    }

    private static void useArithmeticException() {
        int a = 5;
        int b = 0;

        // attempting to divide by zero
        try {
            int division = a / b;
            System.out.println(division);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }


}
