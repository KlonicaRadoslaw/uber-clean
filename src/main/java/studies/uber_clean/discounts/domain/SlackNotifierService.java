package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 5
// Implementacja
public class SlackNotifierService extends BaseNotifierService {
    @Override
    public void sendNotification(String userId, String message) {
        System.out.println("Slack -> " + userId + ": " + message);
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 5