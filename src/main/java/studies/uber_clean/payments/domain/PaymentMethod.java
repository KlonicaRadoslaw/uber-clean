package studies.uber_clean.payments.domain;

// Tydzień 2, Wzorzec Bridge 1
// Tydzień 4, Wzorzec Proxy 1
// Definiuje interfejs dla różnych metod płatności.
// Umożliwia tworzenie różnych sposobów płatności bez powiązania z konkretnymi typami transportu
public interface PaymentMethod {
    void pay(double amount);
}
// Koniec, Tydzień 2, Wzorzec Bridge 1
// Koniec, Tydzień 4, Wzorzec Proxy 1