package com.abcbank.customer.service;

import com.abcbank.customer.dto.CustomerDto;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto fetchCustomer(Long id);
}
