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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.abcbank.customer.CustomerTestHelper.createCustomer;
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
}