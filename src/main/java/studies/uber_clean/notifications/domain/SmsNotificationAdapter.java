package studies.uber_clean.notifications.domain;

import org.springframework.stereotype.Service;

// Tydzień 2, Wzorzec Adapter 2
// Adapter obsługujący zewnętrzny system powiadomien
@Service
public class SmsNotificationAdapter implements NotificationSender {
    private final SmsProvider smsProvider;

    public SmsNotificationAdapter(SmsProvider smsProvider) {
        this.smsProvider = smsProvider;
    }

    @Override
    public void send(String recipient, String message) {
        smsProvider.sendSms(recipient, message);
    }
}
// Koniec, Tydzien 2, Wzorzec Adapter 2