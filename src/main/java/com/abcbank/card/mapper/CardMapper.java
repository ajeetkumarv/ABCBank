package com.abcbank.card.mapper;

import com.abcbank.card.dto.CardDto;
import com.abcbank.card.model.Card;

public class CardMapper {

    private CardMapper() {}

    public static CardDto toCardDto(Card card) {
        return CardDto.builder()
                .paymentNetwork(card.getPaymentNetwork())
                .cardType(card.getCardType())
                .cardholderName(card.getCardholderName())
                .cardNumber(card.getCardNumber())
                .expiryMonth(card.getExpiryMonth())
                .expiryYear(card.getExpiryYear())
                .cvv(card.getCvv())
                .build();
    }

    public static Card toCard(CardDto cardDto) {
        Card card = new Card();

        card.setPaymentNetwork(cardDto.getPaymentNetwork());
        card.setCardType(cardDto.getCardType());
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardholderName(cardDto.getCardholderName());
        card.setExpiryMonth(cardDto.getExpiryMonth());
        card.setExpiryYear(cardDto.getExpiryYear());
        card.setCvv(cardDto.getCvv());

        return card;
    }
}
