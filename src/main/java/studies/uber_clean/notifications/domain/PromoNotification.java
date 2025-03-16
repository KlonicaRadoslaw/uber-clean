package studies.uber_clean.notifications.domain;

// Tydzień 2, Wzorzec Bridge 2
// Reprezentuje powiadomienie o promocji.
// Specyficzna implementacja powiadomienia, która również korzysta z dowolnej metody przesłania powiadomienia.
public class PromoNotification extends Notification {
    public PromoNotification(NotificationSender sender) {
        super(sender);
    }

    @Override
    public void sendNotification(String recipient, String message) {
        sender.send(recipient, "Promo Notification: " + message);
    }
}
// Koniec, Tydzień 2, Wzorzec Bridge 2