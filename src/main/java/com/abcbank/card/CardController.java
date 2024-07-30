package com.abcbank.card;

import com.abcbank.card.dto.CardDto;
import com.abcbank.card.model.CardType;
import com.abcbank.card.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<CardDto> createCard(@RequestBody CardDto cardDto) {

        CardDto cardDtoResponse = cardService.createCard(cardDto);

        Long cardNumber = cardDtoResponse.getCardNumber();

        log.info("Created new card: " + cardNumber);

        URI uri = URI.create("localhost:8080/card/" + cardNumber);
        return ResponseEntity.created(uri)
                .body(cardDto);
    }

    @GetMapping("/{cardNumber}")
    public CardDto fetchCard(@PathVariable Long cardNumber) {
        CardDto cardDto = cardService.fetchCard(cardNumber);

        return cardDto;
    }

    @GetMapping("/find")
    public List<CardDto> findCard(
            @RequestParam CardType cardType,
            @RequestParam String cardholderName,
            @RequestParam Short expiryMonth,
            @RequestParam Short expiryYear,
            @RequestParam Short cvv
            ) {
        List<CardDto> cardDto = cardService.findCard(
                cardType, cardholderName, expiryMonth, expiryYear, cvv);

        return cardDto;
    }

    @DeleteMapping("/{cardNumber}")
    public ResponseEntity<String> deleteCard(@PathVariable Long cardNumber) {
        cardService.deleteCard(cardNumber);

        return ResponseEntity.ok("Card deleted successfully.");
    }
}
