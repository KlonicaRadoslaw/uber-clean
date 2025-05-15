package studies.uber_clean.discounts.domain;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Tydzień 10, Predicate i Function 1
public class DiscountPredicateFunctionUsage {
    public static void main(String[] args) {
        List<Double> rideCosts = List.of(30.0, 60.0, 150.0, 210.0);

        Predicate<Double> eligibleForPromo = cost -> cost >= 100;
        Function<Double, Double> applyPromo = cost -> cost * 0.85; // 15% zniżki

        List<Double> finalPrices = rideCosts.stream()
                .filter(eligibleForPromo)
                .map(applyPromo)
                .collect(Collectors.toList());

        System.out.println("Ceny po promocji (dla kursów >= 100 zł): " + finalPrices);
    }
}
// Koniec, Tydzień 10, Predicate i Function 1