package studies.uber_clean.payments.domain;

public class PaymentFacade {

    private final PaymentProcessor paymentProcessor;
    public PaymentFacade(PaymentProcessor paymentProcessor){this.paymentProcessor = paymentProcessor;}

    // Tydzień 2, Wzorzec Adapter 1
    // Użycie obsługi płatności
    public boolean processPayment(String accountNumber, double amount) {
        return paymentProcessor.pay(accountNumber, amount);
    }
    // Koniec, Tydzień 1, Wzorzec Adapter 1
}
