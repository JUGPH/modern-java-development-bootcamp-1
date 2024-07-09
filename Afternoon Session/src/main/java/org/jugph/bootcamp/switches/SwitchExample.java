    package org.jugph.bootcamp.switches;

    enum PaymentType {
        CREDIT, MAYA, GCASH, CASH
    }

    record Payment(PaymentType paymentType, double amount, boolean hasVoucher){}

    public class SwitchExample {

        void main() {
            System.out.println(getProcessPaymentMessage(new Payment(PaymentType.MAYA, 300.00, true)));
            System.out.println(getProcessPaymentMessage(new Payment(PaymentType.CREDIT, 300.00, false)));
        }

        public static String getProcessPaymentMessage(Payment payment) {
            var discount = 0;
            var type = switch(payment.paymentType()) {
                case CREDIT -> "card payment";
                case GCASH, MAYA -> {
                    if(payment.hasVoucher()) {
                        discount = 10;
                    }

                    yield "e-wallet payment";
                }
                case CASH -> "cash payment";
                case null -> "null payment";
            };

            return STR."Processed payment of PHP \{payment.amount()} with \{type} and discount of \{discount}%";
        }

    }
