package com.abcbank.customer.service;

import com.abcbank.customer.dto.CustomerDto;
import com.abcbank.customer.mapper.CustomerMapper;
import com.abcbank.customer.model.Customer;
import com.abcbank.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void createCustomer_success() {
        CustomerDto customerDto = CustomerMapper.toCustomerDto(createCustomer());

        Customer expectedCustomer = CustomerMapper.toCustomer(customerDto);
        expectedCustomer.setId(1L);

        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(expectedCustomer);

        CustomerDto customerCreateResult = customerService.createCustomer(customerDto);

        assertThat(customerCreateResult).isNotNull();
        assertThat(customerCreateResult.getId()).isGreaterThan(0L);
    }

    /* HELPER METHODS */

    private Customer createCustomer() {
        Customer customer = new Customer();

        customer.setSalutation("Mr.");
        customer.setFirstName("Tom");
        customer.setMiddleName("Vergese");
        customer.setLastName("Franken");
        customer.setDateOfBirth(LocalDate.now().minusYears(20));

        return customer;
    }

}