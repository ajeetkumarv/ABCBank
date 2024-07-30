package com.abcbank.card.service;

import com.abcbank.card.dto.CardDto;
import com.abcbank.card.mapper.CardMapper;
import com.abcbank.card.model.Card;
import com.abcbank.card.model.CardType;
import com.abcbank.card.model.PaymentNetwork;
import com.abcbank.card.repository.CardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardNumberGenerator cardNumberGenerator;

    public CardDto createCard(CardDto cardDto) {

        if (cardDto.getPaymentNetwork() != PaymentNetwork.VISA) {
            throw new UnsupportedOperationException("Only Visa card can be issued for now.");
        }

        Long newCardNumber = cardNumberGenerator.generateVisaNumber();

        cardDto.setCardNumber(newCardNumber);

        Card newCard = CardMapper.toCard(cardDto);

        Card savedCard = cardRepository.save(newCard);

        return CardMapper.toCardDto(savedCard);
    }

    @Override
    public void deleteCard(Long cardNumber) {
        Optional<Card> cardOptional = cardRepository.findById(cardNumber);

        if(cardOptional.isEmpty()) {
            throw new EntityNotFoundException("No Card found for number: " + cardNumber);
        }

        cardRepository.deleteById(cardNumber);
    }

    @Override
    public CardDto fetchCard(Long cardNumber) {

        Optional<Card> cardOptional = cardRepository.findById(cardNumber);

        Card card = cardOptional.orElseThrow(() -> new EntityNotFoundException("No Card found for number: " + cardNumber));
        return CardMapper.toCardDto(card);
    }

    @Override
    public List<CardDto> findCard(CardType cardType, String cardholderName,
                                  Short expiryMonth, Short expiryYear, Short cvv) {
        // implement pageable
        return List.of();
    }
}
