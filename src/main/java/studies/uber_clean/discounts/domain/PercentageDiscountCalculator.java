package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 7
// Implementacja
public class PercentageDiscountCalculator implements DiscountCalculator {
    // Tydzień 9, magic numbers
    private static final double DISCOUNT_PERCENTAGE = 0.1;
    @Override
    public double calculateDiscount(double totalPrice) {
        return totalPrice * DISCOUNT_PERCENTAGE; // 10%
    }
    // Koniec, Tydzień 9, magic numbers
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 7