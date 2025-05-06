package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 6
// Implementacja
public class ConsoleDiscountLogger implements DiscountLogger {
    @Override
    public void logDiscount(String message) {
        System.out.println("DISCOUNT LOG: " + message);
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 6