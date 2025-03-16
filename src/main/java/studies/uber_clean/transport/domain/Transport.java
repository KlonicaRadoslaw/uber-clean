package studies.uber_clean.transport.domain;

import studies.uber_clean.payments.domain.PaymentMethod;

// Tydzień 2, Wzorzec Bridge 1
// Definiuje interfejs dla różnych typów transportu i przechowuje referencję do PaymentMethod.
// Umożliwia korzystanie z dowolnej metody płatności z dowolnym typem transportu, co realizuje wzorzec Bridge.
public abstract class Transport {
    protected PaymentMethod paymentMethod;

    public Transport(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public abstract void bookTransport(double amount);
}
// Koniec, Tydzień 2, Wzorzec Bridge 1