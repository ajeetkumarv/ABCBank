package com.abcbank.customer.mapper;

import com.abcbank.customer.dto.CustomerDto;
import com.abcbank.customer.model.Customer;

public class CustomerMapper {

    public static Customer toCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setId(customerDto.getId());
        customer.setSalutation(customer.getSalutation());
        customer.setFirstName(customerDto.getFirstName());
        customer.setMiddleName(customerDto.getMiddleName());
        customer.setLastName(customerDto.getLastName());
        customer.setDateOfBirth(customerDto.getDateOfBirth());

        return customer;
    }

    public static CustomerDto toCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .dateOfBirth(customer.getDateOfBirth())
                .salutation(customer.getSalutation())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .build();
    }
}
