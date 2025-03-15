package studies.uber_clean.payments.domain;

// Tydzień 2, Wzorzec Adapter 1
// Adapter obsługujący zewnętrzny system płatności
public interface PaymentProcessor {
    boolean pay(String accountNumber, double amount);
}
// Koniec, Tydzień 2, Wzorzec Adapter 1