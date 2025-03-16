package studies.uber_clean.payments.domain;

// Tydzień 2, Wzorzec Bridge 1
// Implementuje płatność kartą.
// Reprezentuje jedną z możliwych metod płatności, która może być użyta przez dowolny typ transportu.
public class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Card.");
    }
}
// Koniec, Tydzień 2, Wzorzec Bridge 1