package studies.uber_clean.notifications.domain;

// Tydzień 2, Wzorzec Adapter 2
// Adapter obsługujący zewnetrzny system powiadomien
public interface NotificationService {
    void sendNotification(String recipient, String message);
}
// Koniec, Tydzień 2, Wzorzec Adapter 2