package com.abcbank.card.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
public class Card {
    private CardType cardType;

    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private short cvv;
    private String cardholderName;

}
