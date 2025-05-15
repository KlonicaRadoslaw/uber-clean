package studies.uber_clean.discounts.domain;

// Tydzień 10, Interfejs funkcyjny 1
@FunctionalInterface
public interface DiscountValidator {
    boolean isValid(double amount);
}
// Koniec, Tydzień 10, Interfejs funkcyjny 1