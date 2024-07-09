package org.jugph.bootcamp.pattern_matching;

public record CreditPayment(String cardNumber, String cardHolderName, String expirationDate, String cvv, double amount)
        implements Payment {


}
