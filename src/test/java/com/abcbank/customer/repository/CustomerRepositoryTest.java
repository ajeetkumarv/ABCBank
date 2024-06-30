package com.abcbank.customer.repository;

import com.abcbank.customer.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        Customer saved = customerRepository.save(createCustomer());

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isGreaterThan(0L);
    }

    @Test
    public void findCustomerById_Found() {
        customerRepository.save(createCustomer());

        Optional<Customer> customerById = customerRepository.findById(1L);

        assertThat(customerById).isNotNull();
    }

    @Test
    public void findCustomerById_NotFound() {
        Optional<Customer> customerFindResult = customerRepository.findById(1L);

        assertThat(customerFindResult).isEmpty();
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