package com.abcbank.card;

import com.abcbank.card.dto.CardDto;
import com.abcbank.card.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
                .build();
    }
}
