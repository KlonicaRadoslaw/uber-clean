package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 10, Functional interface 2
@FunctionalInterface
public interface LoyaltyPointsCalculator {
    int calculatePoints(double rideValue);
}
// Koniec, Tydzień 10, Functional interface 2