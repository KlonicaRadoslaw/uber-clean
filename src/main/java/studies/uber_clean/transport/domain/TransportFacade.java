package studies.uber_clean.transport.domain;

import studies.uber_clean.payments.domain.CardPayment;
import studies.uber_clean.payments.domain.CashPayment;
import studies.uber_clean.payments.domain.PaymentMethod;
import studies.uber_clean.payments.domain.PaymentProxy;

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
    // Tydzień 4, Wzorzec Proxy 1
    /**
     * Metoda rezerwująca transport i realizująca płatność.
     * @param amount Kwota do zapłaty.
     * @param paymentType Typ płatności ("card" lub "cash").
     */
    public void bookTransportWithProxy(double amount, String paymentType) {
        PaymentMethod paymentMethod = getPaymentMethod(paymentType); // Pobranie metody płatności
        PaymentProxy proxy = new PaymentProxy(paymentMethod);  // Użycie proxy do logowania
        proxy.pay(amount); // Wykonanie płatności przez Proxy
    }
    // Koniec, Tydzień 4, Wzorzec Proxy 1

    /**
     * Metoda zwracająca odpowiedni obiekt płatności na podstawie przekazanego typu.
     * @param type Typ płatności (np. "card", "cash").
     * @return Obiekt implementujący interfejs PaymentMethod.
     * @throws IllegalArgumentException W przypadku nieobsługiwanej metody płatności.
     */
    private PaymentMethod getPaymentMethod(String type) {
        return switch (type.toLowerCase()) {
            case "card" -> new CardPayment();
            case "cash" -> new CashPayment();
            default -> throw new IllegalArgumentException("Unsupported payment method: " + type);
        };
    }
}
