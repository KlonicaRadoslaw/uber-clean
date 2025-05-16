package studies.uber_clean.loyaltyProgram.domain;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
// Tydzień 10, Predicate and Function 2
public class LoyaltyPredicateFunctionUsage {
    private final static int MINIMAL_MEMBER_POINTS = 500;

    public static void main(String[] args) {
        List<LoyaltyMember> members = List.of(
                new LoyaltyMember("Anna", 520),
                new LoyaltyMember("Bartek", 410),
                new LoyaltyMember("Celina", 800)
        );

        // Predicate: sprawdza czy ktoś ma powyżej 500 punktów
        Predicate<LoyaltyMember> hasBonus = member -> member.getPoints() > MINIMAL_MEMBER_POINTS;

        // Function: zwraca komunikat powitalny z liczbą punktów
        Function<LoyaltyMember, String> greeting = member ->
                "Cześć " + member.getName() + ", masz " + member.getPoints() + " punktów.";

        members.stream()
                .filter(hasBonus)
                .map(greeting)
                .forEach(System.out::println);
    }
}

class LoyaltyMember {
    private String name;
    private int points;

    public LoyaltyMember(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}
// Koniec, Tydzień 10, Predicate and Function 2