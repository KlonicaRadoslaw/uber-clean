package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 7
// Tydzień 10, Interfejs funkcyjny 1
@FunctionalInterface
public interface DiscountCalculator {
    double calculateDiscount(double amount);
}
// Koniec, Tydzień 10, Interfejs funkcyjny 1
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 7