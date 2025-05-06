package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 8
// Implementacja
public class EmailDiscountNotifier implements DiscountNotifier {
    @Override
    public void notifyUser(String userId, double discountAmount) {
        System.out.println("Email sent to user " + userId + ": Discount applied - " + discountAmount);
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 8