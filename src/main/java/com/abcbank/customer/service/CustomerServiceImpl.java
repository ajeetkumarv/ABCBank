package com.abcbank.customer.service;

import com.abcbank.customer.dto.CustomerDto;
import com.abcbank.customer.mapper.CustomerMapper;
import com.abcbank.customer.model.Customer;
import com.abcbank.customer.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
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

        Customer customer = customerDto.orElseThrow(
                () -> new EntityNotFoundException("Customer not found with id: " + id));
        return CustomerMapper.toCustomerDto(customer);
    }
}
