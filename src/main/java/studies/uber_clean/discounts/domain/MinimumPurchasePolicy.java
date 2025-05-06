package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 9
// Implementacja
public class MinimumPurchasePolicy extends DiscountPolicy {
    @Override
    public boolean isApplicable(double totalPrice) {
        return totalPrice >= 100;
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 9