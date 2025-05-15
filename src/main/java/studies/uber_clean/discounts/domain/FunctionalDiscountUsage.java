package studies.uber_clean.discounts.domain;

// Tydzień 10, Interfejs funkcyjny 1
public class FunctionalDiscountUsage {
    public static void main(String[] args) {
        DiscountCalculator calculator = amount -> amount * 0.85; // 15% zniżki
        DiscountLogger logger = message -> System.out.println("LOG: " + message);
        DiscountValidator validator = amount -> amount >= 100;

        double price = 200;
        if (validator.isValid(price)) {
            double discounted = calculator.calculateDiscount(price);
            logger.logDiscount("Zniżka zastosowana: " + discounted);
        } else {
            logger.logDiscount("Zniżka nie dotyczy kwoty: " + price);
        }
    }
}
// Koniec Tydzień 10, Interfejs funkcyjny 1