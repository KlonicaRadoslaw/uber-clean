package studies.uber_clean.notifications.domain;

import org.springframework.stereotype.Component;

// Tydzień 2, Wzorzec Adapter 2
// Symulacja zewnętrznego systemu powiadomien email
@Component
class EmailProvider {
    public void sendEmail(String email, String subject, String body) {
        System.out.println("Sending Email to " + email + ": " + subject + " - " + body);
    }
}
// Koniec, Tydzien 2, Wzorzec Adapter 2