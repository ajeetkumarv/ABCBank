package com.abcbank.customer;

import com.abcbank.customer.model.Customer;

import java.time.LocalDate;

public class CustomerTestHelper {

    private CustomerTestHelper() {}

    public static Customer createCustomer() {
        Customer customer = new Customer();

        customer.setSalutation("Mr.");
        customer.setFirstName("Tom");
        customer.setMiddleName("Vergese");
        customer.setLastName("Franken");
        customer.setDateOfBirth(LocalDate.now().minusYears(20));

        return customer;
    }
}
