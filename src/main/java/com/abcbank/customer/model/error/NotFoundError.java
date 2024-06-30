package com.abcbank.customer.model.error;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NotFoundError {
    private String msg;
    private String identifierName;
    private String value;
}
