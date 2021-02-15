package com.sda.exceptions;

public class CustomException extends RuntimeException {

    // wrong
    public CustomException(String message) {
        super(message);
    }

    // right
    public CustomException(String message, RuntimeException cause) {
        super(message, cause);
    }
}
