package studies.uber_clean.notifications.domain;

import org.springframework.stereotype.Service;

// Tydzień 2, Wzorzec Adapter 2
// Adapter obsługujący zewnętrzny system powiadomien
@Service
public class EmailNotificationAdapter implements NotificationSender {
    private final EmailProvider emailProvider;

    public EmailNotificationAdapter() {
        this.emailProvider = new EmailProvider();
    }

    @Override
    public void send(String recipient, String message) {
        emailProvider.sendEmail(recipient, "Uber Notification", message);
    }
}
// Koniec, Tydzien 2, Wzorzec Adapter 2
