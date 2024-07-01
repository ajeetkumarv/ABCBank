package com.abcbank.customer;

import com.abcbank.customer.dto.CustomerDto;
import com.abcbank.customer.model.Customer;
import com.abcbank.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.abcbank.customer.CustomerTestHelper.createCustomer;
import static com.abcbank.customer.mapper.CustomerMapper.toCustomerDto;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)
//@SpringBootTest // all is already with @WebMvcTest
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    public void createCustomer_success() {
        Customer customer = createCustomer();
        customer.setId(1L);
        CustomerDto resultDto = toCustomerDto(customer);

        /* BDD Style */
        //BDDMockito.given(customerService.createCustomer(ArgumentMatchers.any()))
        //        .willAnswer(invocation -> resultDto);


        when(customerService.createCustomer(ArgumentMatchers.any())).thenReturn(resultDto);

        ResultActions response = mockMvc.perform(post("/customer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createCustomer())));

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
        response.andExpect(MockMvcResultMatchers.jsonPath("firstName", is("Tom")));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
    }



}