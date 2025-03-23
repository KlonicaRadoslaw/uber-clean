package studies.uber_clean.notifications.domain;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Proxy 2
// Klasa Proxy, która ogranicza liczbę wysyłanych powiadomień do jednego odbiorcy w krótkim czasie
public class NotificationRateLimiterProxy implements NotificationSender {
    private final NotificationSender realSender;
    private final Map<String, Long> lastSentTime = new HashMap<>();
    private static final long THROTTLE_TIME_MS = 5000; // Ograniczenie: 5 sekund między powiadomieniami

    public NotificationRateLimiterProxy(NotificationSender realSender) {
        this.realSender = realSender;
    }

    @Override
    public void send(String recipient, String message) {
        long currentTime = System.currentTimeMillis();
        if (lastSentTime.containsKey(recipient) && (currentTime - lastSentTime.get(recipient)) < THROTTLE_TIME_MS) {
            System.out.println("Rate limit reached: Skipping notification to " + recipient);
            return;
        }
        lastSentTime.put(recipient, currentTime);
        realSender.send(recipient, message);
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy 2