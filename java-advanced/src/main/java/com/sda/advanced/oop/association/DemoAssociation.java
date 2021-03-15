package com.sda.advanced.oop.association;

// one-to-one
// one-to-many
// many-to-one
// many-to-many
public class DemoAssociation {

    public static void main(String[] args) {
        Bank bank = new Bank("BCR");
        Employee employee = new Employee("Jon");

        // ASSOCIATION
        System.out.println(employee.getEmployeeName() +
                " is employee of " + bank.getBankName());
    }
}
