package com.abcbank.customer.service;

import com.abcbank.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto fetchCustomer(Long id);
    List<CustomerDto> fetchAllCustomers();

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomer(Long id);
}
