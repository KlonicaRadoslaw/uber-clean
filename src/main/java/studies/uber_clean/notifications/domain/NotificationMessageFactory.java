package studies.uber_clean.notifications.domain;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight 2
public class NotificationMessageFactory {
    private static final Map<String, NotificationMessage> messages = new HashMap<>();

    public static NotificationMessage getMessage(String type, String content) {
        String key = type + ":" + content;
        messages.putIfAbsent(key, new NotificationMessage(type, content));
        return messages.get(key);
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight 2