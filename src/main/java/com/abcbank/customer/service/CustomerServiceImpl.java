package com.abcbank.customer.service;

import com.abcbank.customer.dto.CustomerDto;
import com.abcbank.customer.mapper.CustomerMapper;
import com.abcbank.customer.model.Customer;
import com.abcbank.customer.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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

        //TODO: Service should not throw JPA related exception. what if we change the persistence strategy
        Customer customer = customerDto.orElseThrow(
                () -> new EntityNotFoundException("Customer not found with id: " + id));
        return CustomerMapper.toCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> fetchAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();//TODO: Make it Pageable

        return allCustomers.stream()
                .map(CustomerMapper::toCustomerDto)
                .toList();
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer customerDetailsToUpdate = CustomerMapper.toCustomer(customerDto);
        Customer updatedCustomer = customerRepository.save(customerDetailsToUpdate);
        return CustomerMapper.toCustomerDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        customerOptional.orElseThrow(() -> new EntityNotFoundException("Customer not found for id: " + id));
        log.info("Deleting customer: " + id);
        customerRepository.deleteById(id);
    }
}
