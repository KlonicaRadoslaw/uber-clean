package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 6
// Tydzień 10, Interfejs funkcyjny 1
@FunctionalInterface
public interface DiscountLogger {
    void logDiscount(String message);
}
// Koniec, Tydzień 10, Interfejs funkcyjny 1
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 6