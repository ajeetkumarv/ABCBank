package com.abcbank.customer.service;

import com.abcbank.customer.dto.CustomerDto;
import com.abcbank.customer.mapper.CustomerMapper;
import com.abcbank.customer.model.Customer;
import com.abcbank.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toCustomer(customerDto);

        Customer customerResult = customerRepository.save(customer);

        return CustomerMapper.toCustomerDto(customerResult);
    }

    @Override
    public CustomerDto fetchCustomer(Long id) {
        Optional<Customer> customerDto = customerRepository.findById(id);
        Customer customer = customerDto.get();
        return CustomerMapper.toCustomerDto(customer);
    }
}
