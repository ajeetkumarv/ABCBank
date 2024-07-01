package com.abcbank.customer;

import com.abcbank.customer.dto.CustomerDto;
import com.abcbank.customer.model.Customer;
import com.abcbank.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto customerDtoResponse = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerDtoResponse, HttpStatus.CREATED); //TODO: Try with .created()
    }

    @GetMapping("/{id}")
    public CustomerDto fetchCustomer(@PathVariable Long id) {
        CustomerDto customerDto = customerService.fetchCustomer(id);
        return customerDto;
    }

    @GetMapping("/all")
    public List<CustomerDto> fetchAllCustomers() { //TODO pagination
        List<CustomerDto> customerDto = customerService.fetchAllCustomers();
        return customerDto;
    }
}
