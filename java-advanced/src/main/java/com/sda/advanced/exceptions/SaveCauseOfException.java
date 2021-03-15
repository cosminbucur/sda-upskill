package com.sda.advanced.exceptions;

public class SaveCauseOfException {

    public static void main(String[] args) {
//        wrong();
        right();
    }

    public static void wrong() {
        try {
            doBusinessLogic();
        } catch (NumberFormatException e) {
            throw new CustomException("dis number ain't good!");
        } catch (IllegalArgumentException e) {
            throw new CustomException("what argument is that?");
        }
    }

    // TIP: use the root cause for a custom exception
    public static void right() {
        try {
            doBusinessLogic();
        } catch (NumberFormatException e) {
            throw new CustomException("dis number ain't good!", e);
        } catch (IllegalArgumentException e) {
            throw new CustomException("what argument is that?", e);
        }
    }

    private static void doBusinessLogic() {
        System.out.println("breakable logic");
        throw new IllegalArgumentException("don't forget about me!");
    }

    enum ErrorCode {
        POLITICS,
        GENDER,
        RELIGION
    }
}
