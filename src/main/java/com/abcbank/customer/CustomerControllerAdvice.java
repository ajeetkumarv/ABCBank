package com.abcbank.customer;

import com.abcbank.customer.model.error.NotFoundError;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@ControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<NotFoundError> noCustomerFound(EntityNotFoundException ex) {
        log.warn(ex.getMessage());

        NotFoundError notFoundErrorResponse = NotFoundError.builder()
                .msg(ex.getMessage())
                .identifierName("id")
                .value("dummy")
                .build();

        return new ResponseEntity<>(notFoundErrorResponse, HttpStatus.NOT_FOUND);
    }
}
