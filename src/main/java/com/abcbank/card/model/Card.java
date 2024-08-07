package com.abcbank.card.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
@Entity
public class Card {
    private PaymentNetwork paymentNetwork;
    private CardType cardType;

    @Id
    private Long cardNumber;
    private short expiryMonth;
    private short expiryYear;
    private short cvv;
    private String cardholderName;
}
