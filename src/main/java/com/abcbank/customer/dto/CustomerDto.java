package com.abcbank.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class CustomerDto {
    private Long id;

    private String salutation; //TODO jsonpropety for multiple values
    private String firstName, middleName, lastName;

    private LocalDate dateOfBirth;
}
