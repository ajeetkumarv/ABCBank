package com.abcbank.card.service;

import com.abcbank.card.dto.CardDto;
import com.abcbank.card.model.CardType;
import com.abcbank.card.model.PaymentNetwork;
import com.abcbank.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CardService {

    CardDto createCard(CardDto cardDto);

    /**
     * Soft delete only
     * @return
     */
    CardDto deleteCard();
}
