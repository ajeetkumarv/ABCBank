package com.abcbank.customer.repository;

import com.abcbank.customer.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        Customer customer = new Customer();

        customer.setSalutation("Mr.");
        customer.setFirstName("Tom");
        customer.setMiddleName("Vergese");
        customer.setLastName("Franken");
        customer.setDateOfBirth(LocalDate.now().minusYears(20));

        Customer saved = customerRepository.save(customer);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isGreaterThan(0L);
    }

}