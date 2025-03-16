package studies.uber_clean.transport.domain;

import studies.uber_clean.payments.domain.PaymentMethod;

// Tydzień 2, Wzorzec Bridge 1
// Reprezentuje transport jedzenia.
// Specyficzna implementacja transportu, która również korzysta z dowolnej metody płatności.
public class FoodTransport extends Transport {
    public FoodTransport(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    @Override
    public void bookTransport(double amount) {
        System.out.print("Booking a food transport. ");
        paymentMethod.pay(amount);
    }
}
// Koniec, Tydzień 2, Wzorzec Bridge 1