package studies.uber_clean.notifications.domain;

// Tydzień 2, Wzorzec Decorator 2
public class LoggingNotificationDecorator implements NotificationSender {
    private final NotificationSender decoratedSender;

    public LoggingNotificationDecorator(NotificationSender decoratedSender) {
        this.decoratedSender = decoratedSender;
    }

    @Override
    public void send(String recipient, String message) {
        System.out.println("Log: Sending notification to " + recipient + " with message: " + message);

        decoratedSender.send(recipient, message);
    }
}
// Koniec, Tydzień 2, Wzorzec Decorator 2