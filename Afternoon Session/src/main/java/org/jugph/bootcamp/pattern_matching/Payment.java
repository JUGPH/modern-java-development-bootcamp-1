package org.jugph.bootcamp.pattern_matching;

public sealed interface Payment permits CreditPayment, CashPayment {

}
