package com.abcbank.card.service;

import org.springframework.stereotype.Service;

@Service
public class CardNumberGenerator {

    private final Long VISA_IDENTIFIER = 4000_0000_0000_0000L;
    private final Long MASTERCARD_IDENTIFIER = 2L;// or 5
    private final Long RUPAY_IDENTIFIER = 60L; // 6051
    private final Long AMEX_IDENTIFIER = 3L;

    private Long lastVisaNumber = 0L;
    private Long lastMastercardNumber = 0L;
    private Long lastRupayNumber = 0L;
    private Long lastAmexNumber = 0L;

    public Long generateVisaNumber() {
        long newVisaCardNumber = VISA_IDENTIFIER + lastVisaNumber + 1;

        validate(newVisaCardNumber);

        return newVisaCardNumber;
    }

    public Long generateMastercardNumber() {
        return null;
    }

    public Long generateRupayNumber() {
        return null;
    }

    public Long generateAmexNumber() {
        return null;
    }

    private void validate(Long newCardNumber) { //TODO: extend for other cards
        if (newCardNumber > 4999_9999_9999_9999L) {
            throw new IllegalStateException("Visa card limit exhausted. Card number can not be issued: " + newCardNumber);
        }
    }

}
