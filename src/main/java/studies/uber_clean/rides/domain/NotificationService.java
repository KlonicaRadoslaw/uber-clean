package studies.uber_clean.rides.domain;

// Tydzień 8, Wzorzec Interface segregation 2
public interface NotificationService {
    void sendEmail(String to, String content);
    void sendSMS(String number, String content);
    void sendPushNotification(String deviceId, String content);
}
// Koniec, Tydzień 8, Wzorzec Interface segregation 2