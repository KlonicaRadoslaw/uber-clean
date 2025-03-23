package studies.uber_clean.payments.domain;

// Tydzień 4, Wzorzec Proxy 1
// Klasa Proxy, która kontroluje dostęp do rzeczywistej implementacji płatności.
// Dodaje logowanie przed i po dokonaniu transakcji.
public class PaymentProxy implements PaymentMethod {
    private final PaymentMethod realPaymentMethod;

    public PaymentProxy(PaymentMethod realPaymentMethod) {
        this.realPaymentMethod = realPaymentMethod;
    }

    @Override
    public void pay(double amount) {
        System.out.println("[LOG] Próba płatności na kwotę: " + amount + " PLN.");
        realPaymentMethod.pay(amount); // Wykonanie rzeczywistej płatności
        System.out.println("[LOG] Płatność zakończona.");
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy 1