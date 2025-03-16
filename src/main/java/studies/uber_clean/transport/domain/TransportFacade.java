package studies.uber_clean.transport.domain;

import studies.uber_clean.payments.domain.CardPayment;
import studies.uber_clean.payments.domain.CashPayment;
import studies.uber_clean.payments.domain.PaymentMethod;

public class TransportFacade {
    public void bookPersonTransport(double amount, String paymentType) {
        PaymentMethod paymentMethod = getPaymentMethod(paymentType);
        Transport transport = new PersonTransport(paymentMethod);
        transport.bookTransport(amount);
    }

    public void bookFoodTransport(double amount, String paymentType) {
        PaymentMethod paymentMethod = getPaymentMethod(paymentType);
        Transport transport = new FoodTransport(paymentMethod);
        transport.bookTransport(amount);
    }

    private PaymentMethod getPaymentMethod(String type) {
        return switch (type.toLowerCase()) {
            case "card" -> new CardPayment();
            case "cash" -> new CashPayment();
            default -> throw new IllegalArgumentException("Unsupported payment method: " + type);
        };
    }
}
