package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 9
// Implementacja

public class MinimumPurchasePolicy extends DiscountPolicy {
    // Tydzień 9, magic numbers
    private static final int MIN_PURCHASE = 100;

    @Override
    public boolean isApplicable(double totalPrice) {
        return totalPrice >= MIN_PURCHASE;
    }
    // Koniec, Tydzień 9, magic numbers
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 9