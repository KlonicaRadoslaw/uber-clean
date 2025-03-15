package studies.uber_clean.payments.domain;

// Tydzień 2, Wzorzec Adapter 1
// Symularacja zewnętrznego systemu płatności
public class ExternalPaymentProcessor {
    public boolean processPayment(String accountNumber, double amount) {
        System.out.println("Processing payment through external system for account: " + accountNumber);
        return true;
    }
}
// Koniec, Tydzień 2, Wzorzec Adapter 1