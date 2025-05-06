package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 8
public interface DiscountNotifier {
    void notifyUser(String userId, double discountAmount);
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 8