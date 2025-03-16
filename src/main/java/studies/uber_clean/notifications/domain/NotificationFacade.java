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

        Notification notification = new PaymentNotification(sender);
        notification.sendNotification(recipient, message);

        return "Notification sent successfully";
    }

    public String sendPromotionNotification(String type, String recipient, String message) {
        NotificationSender sender = getSender(type);

        Notification notification = new PromoNotification(sender);
        notification.sendNotification(recipient, message);

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
