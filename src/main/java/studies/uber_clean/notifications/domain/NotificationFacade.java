package studies.uber_clean.notifications.domain;

import java.util.NoSuchElementException;

public class NotificationFacade {
    private final SmsNotificationAdapter smsNotificationAdapter;
    private final EmailNotificationAdapter emailNotificationAdapter;

    public NotificationFacade(SmsNotificationAdapter smsNotificationAdapter, EmailNotificationAdapter emailNotificationAdapter) {
        this.smsNotificationAdapter = smsNotificationAdapter;
        this.emailNotificationAdapter = emailNotificationAdapter;
    }

    public String sendPaymentNotification(String type, String recipient, String message) {
        NotificationSender sender = getSender(type);

        // Tydzień 4, Wzorzec Flyweight 2
        NotificationMessage notificationMessage = NotificationMessageFactory.getMessage("Payment", message);
        Notification notification = new PaymentNotification(sender);
        notification.sendNotification(recipient, notificationMessage.getFormattedMessage());
        // Koniec, Tydzień 4, Wzorzec Flyweight 2

        return "Notification sent successfully";
    }

    public String sendPromotionNotification(String type, String recipient, String message) {
        NotificationSender sender = getSender(type);

        // Tydzień 4, Wzorzec Flyweight 2
        NotificationMessage notificationMessage = NotificationMessageFactory.getMessage("Promotion", message);
        Notification notification = new PromoNotification(sender);
        notification.sendNotification(recipient, notificationMessage.getFormattedMessage());
        // Koniec, Tydzień 4, Wzorzec Flyweight 2

        return "Notification sent successfully";
    }

    public String sendPromotionNotificationWithLogging(String type, String recipient, String message) {
        NotificationSender sender = getSender(type);

        // Opakowujemy w dekorator i wywołujemy metodę sendNotification
        NotificationSender decoratedSender = new LoggingNotificationDecorator(sender);
        Notification notification = new PromoNotification(decoratedSender);
        notification.sendNotification(recipient, message); // Wywołanie metody sendNotification na dekorowanym obiekcie

        return "Notification sent successfully";
    }

    // Tydzień 4, Wzorzec Proxy 2
    public String sendPaymentNotificationWithProxyLimiter(String type, String recipient, String message) {
        NotificationSender sender = getSender(type);

        // Używamy Proxy do ograniczenia wysyłki
        NotificationSender proxySender = new NotificationRateLimiterProxy(sender);

        Notification notification = new PaymentNotification(proxySender);
        notification.sendNotification(recipient, message);

        return "Notification with proxy limiter sent successfully";
    }

    public String sendPromotionNotificationWithProxyLimiter(String type, String recipient, String message) {
        NotificationSender sender = getSender(type);

        // Używamy Proxy do ograniczenia wysyłki
        NotificationSender proxySender = new NotificationRateLimiterProxy(sender);

        Notification notification = new PromoNotification(proxySender);
        notification.sendNotification(recipient, message);

        return "Notification with proxy limiter sent successfully";
    }
    // Koniec, Tydzień 4, Wzorzec Proxy 2

    private NotificationSender getSender(String type) {
        switch (type.toLowerCase()) {
            case "sms" -> {
                return smsNotificationAdapter;
            }
            case "email" -> {
                return emailNotificationAdapter;
            }
            default -> throw new NoSuchElementException("Invalid notification type");
        }
    }
}
