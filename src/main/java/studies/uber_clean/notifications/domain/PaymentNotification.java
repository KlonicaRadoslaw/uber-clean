package studies.uber_clean.notifications.domain;

// Tydzień 2, Wzorzec Bridge 2
// Reprezentuje powiadomienie o płatności.
// Specyficzna implementacja powiadomienia, która również korzysta z dowolnej metody przesłania powiadomienia.
public class PaymentNotification extends Notification {
    public PaymentNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    public void sendNotification(String recipient, String message) {
        sender.send(recipient, "Payment Notification: " + message);
    }
}
// Koniec, Tydzień 2, Wzorzec Bridge 2