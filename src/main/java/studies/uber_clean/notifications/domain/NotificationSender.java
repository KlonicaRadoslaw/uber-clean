package studies.uber_clean.notifications.domain;

public interface NotificationSender {
    void send(String recipient, String message);
}