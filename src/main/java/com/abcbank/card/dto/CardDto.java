package com.abcbank.card.dto;

import com.abcbank.card.model.CardType;
import com.abcbank.card.model.PaymentNetwork;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDto {
    private PaymentNetwork paymentNetwork;
    private CardType cardType;

    private Long cardNumber;
    private short expiryMonth;
    private short expiryYear;
    private short cvv;
    private String cardholderName;
}
