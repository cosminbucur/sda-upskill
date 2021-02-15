package com.sda.patterns.creational.builder4;

import org.junit.jupiter.api.Test;

class Builder4Test {

    @Test
    void givenBankAccount_whenCreate_thenOk() {
        BankAccount account = new BankAccount.Builder(12L)
                .withOwner("test")
                .openingBalance(500)
                .atBranch("branch")
                .atRate(1.5)
                .build();
    }

}