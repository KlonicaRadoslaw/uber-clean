package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 5
public abstract class BaseNotifierService {
    public abstract void sendNotification(String userId, String message);
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 5