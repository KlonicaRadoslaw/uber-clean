package studies.uber_clean.notifications.domain;

// Tydzień 2, Wzorzec Bridge 2
// Definiuje interfejs dla różnych typów powiadomien i przechowuje referencję do NotificationSender.
// Umożliwia korzystanie z dowolnego rodzaju powiadomienia ze sposobem jego wysyłki, co realizuje wzorzec Bridge.
public abstract class Notification {
    protected NotificationSender sender;

    public Notification(NotificationSender sender) {
        this.sender = sender;
    }

    public abstract void sendNotification(String recipient, String message);
}
// Koniec, Tydzień 2, Wzorzec Bridge 2