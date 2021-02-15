package com.sda.oop.association;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<Employee> employees = new ArrayList<>();
    private String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return this.bankName;
    }
}

