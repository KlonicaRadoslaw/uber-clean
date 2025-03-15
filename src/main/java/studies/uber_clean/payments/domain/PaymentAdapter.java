package studies.uber_clean.payments.domain;

// Tydzień 2, Wzorzec Adapter 1
// Adapter obsługujący zewnętrzny system płatności
public class PaymentAdapter implements PaymentProcessor {
    private final ExternalPaymentProcessor externalPaymentProcessor;

    public PaymentAdapter(ExternalPaymentProcessor externalPaymentProcessor) {
        this.externalPaymentProcessor = externalPaymentProcessor;
    }

    @Override
    public boolean pay(String accountNumber, double amount) {
        return externalPaymentProcessor.processPayment(accountNumber, amount);
    }
}
// Koniec, Tydzień 1, Wzorzec Adapter 1
