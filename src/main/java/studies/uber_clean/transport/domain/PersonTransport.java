package studies.uber_clean.transport.domain;

import studies.uber_clean.payments.domain.PaymentMethod;

// Tydzień 2, Wzorzec Bridge 1
// Reprezentuje transport osób.
// Specyficzna implementacja transportu, która wykorzystuje dowolną metodę płatności.
public class PersonTransport extends Transport {
    public PersonTransport(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    @Override
    public void bookTransport(double amount) {
        System.out.print("Booking a person transport. ");
        paymentMethod.pay(amount);
    }
}
// Koniec, Tydzień 2, Wzorzec Bridge 1