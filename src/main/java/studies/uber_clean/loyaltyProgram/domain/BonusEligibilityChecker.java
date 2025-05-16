package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 10, Functional interface 2
@FunctionalInterface
public interface BonusEligibilityChecker {
    boolean isEligible(int totalPoints);
}
// Koniec, Tydzień 10, Functional interface 2