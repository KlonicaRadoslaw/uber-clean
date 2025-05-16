package studies.uber_clean.loyaltyProgram.domain;

import java.util.Comparator;
import java.util.List;

// Tydzień 10, Stream collection processing 2
public class LoyaltyStreamProcessor {
    private final static int MINIMAL_NAME_LENGTH = 4;
    private final static int MINIMAL_RAID_VALUE = 20;

    public static void main(String[] args) {
        List<String> members = List.of("Anna", "Bartek", "Celina", "Daniel", "Ewa");
        List<Double> rideValues = List.of(12.5, 23.0, 8.0, 34.5, 15.0);
        List<Integer> points = List.of(120, 230, 80, 345, 150);

        // Wypisz członków z imieniem > 4 znaków
        System.out.println("Członkowie z długim imieniem:");
        members.stream()
                .filter(name -> name.length() > MINIMAL_NAME_LENGTH)
                .forEach(System.out::println);

        // Przefiltruj i zsumuj tylko wartości przejazdów > 20
        double total = rideValues.stream()
                .filter(v -> v > MINIMAL_RAID_VALUE)
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.println("Suma większych przejazdów: " + total);

        // Posortuj punkty malejąco i wyświetl top 3
        System.out.println("Top 3 wyniki punktowe:");
        points.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    }
}
// Koniec, Tydzień 10, Stream collection processing 2