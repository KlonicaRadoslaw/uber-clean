package studies.uber_clean.notifications.domain;

import org.springframework.stereotype.Component;

// Tydzień 2, Wzorzec Adapter 2
// Symulacja zewnętrznego systemu powiadomien sms
@Component
class SmsProvider {
    public void sendSms(String phoneNumber, String text) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + text);
    }
}
// Koniec, Tydzień 2, Wzorzec Adapter 2