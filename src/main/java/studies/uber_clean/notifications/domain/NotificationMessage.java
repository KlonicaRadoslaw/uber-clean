package studies.uber_clean.notifications.domain;

// Tydzień 4, Wzorzec Flyweight 2
public class NotificationMessage {
    private final String type;
    private final String content;

    public NotificationMessage(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getFormattedMessage() {
        return "[" + type + "] " + content;
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight 2