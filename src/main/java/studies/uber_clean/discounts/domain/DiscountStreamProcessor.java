package studies.uber_clean.discounts.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Tydzień 10, Strumieniowe przetwarzanie kolekcji 1
public class DiscountStreamProcessor {
    public static void main(String[] args) {
        List<Double> rideCosts = List.of(45.0, 89.0, 120.0, 200.0);
        Set<String> rideTypes = Set.of("Economy", "Premium", "Shared");
        Map<String, Double> cityDiscounts = Map.of(
                "Warsaw", 0.10,
                "Krakow", 0.15,
                "Gdansk", 0.05
        );

        // 1. Obniż koszt kursów > 80 zł o 25%
        List<Double> discountedRides = rideCosts.stream()
                .filter(c -> c > 80)
                .map(c -> c * 0.75)
                .collect(Collectors.toList());
        System.out.println("Ceny po rabacie: " + discountedRides);

        // 2. Wypisz typy kursów w formacie UPPERCASE
        rideTypes.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 3. Miasta, które oferują zniżki powyżej 10%
        cityDiscounts.entrySet().stream()
                .filter(e -> e.getValue() > 0.10)
                .forEach(e -> System.out.println("Miasto: " + e.getKey() + " - Zniżka: " + e.getValue() * 100 + "%"));
    }
}
// Koniec, Tydzień 10, Strumieniowe przetwarzanie kolekcji 1