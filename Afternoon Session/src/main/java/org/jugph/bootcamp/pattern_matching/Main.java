package org.jugph.bootcamp.pattern_matching;


public class Main {

    void main() {
        System.out.println(getPaymentType(new CreditPayment("123", "test", "2024/07/21", "476", 500)));
    }

    public static String getPaymentType(Payment payment) {
        var discount = 0;

        if(payment == null) {
            return "null payment";
        }

        String type;
        type = switch(payment) {
            case CreditPayment(var cardNumber, var cardHolderName, var expirationDate, var cvv, var amount) ->
                    "credit Payment with credit card number " + amount;
            case CashPayment(double amount, String currency) when amount > 1000 -> "cash Payment with currency of " + currency + " and discount of 10%";
            case CashPayment(double amount, String currency) -> "cash Payment with currency of " + currency;
        };

        return type;
    }
}
