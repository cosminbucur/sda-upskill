package com.sda.solid.open_closed.after;

public class SimpleCalculator implements ICalculator {

    @Override
    public void calculate(IOperation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("some message");
        }

        operation.performOperation();
    }
}
