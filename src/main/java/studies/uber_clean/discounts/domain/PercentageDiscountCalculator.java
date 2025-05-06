package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 7
// Implementacja
public class PercentageDiscountCalculator implements DiscountCalculator {
    @Override
    public double calculateDiscount(double totalPrice) {
        return totalPrice * 0.1; // 10%
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 7