package com.abcbank.card.service;

import com.abcbank.card.dto.CardDto;
import com.abcbank.card.model.CardType;
import com.abcbank.card.model.PaymentNetwork;
import com.abcbank.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CardService {

    CardDto createCard(CardDto cardDto);

    /**
     * Soft delete only
     * @return
     */
    void deleteCard(Long cardNumber);

    CardDto fetchCard(Long cardNumber);
    List<CardDto> findCard(CardType cardType, String cardholderName, Short expiryMonth, Short expiryYear, Short cvv);
}
