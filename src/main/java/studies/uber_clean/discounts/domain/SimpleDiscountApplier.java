package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 4
// Implementacja
public class SimpleDiscountApplier extends BaseDiscountApplier {
    @Override
    public void applyDiscount(double amount) {
        System.out.println("Applying discount: " + amount);
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 4