package org.jugph.bootcamp.pattern_matching;

public record CashPayment(double amount, String currency) implements Payment {}
