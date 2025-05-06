package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 9
public abstract class DiscountPolicy {
    public abstract boolean isApplicable(double totalPrice);
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 9