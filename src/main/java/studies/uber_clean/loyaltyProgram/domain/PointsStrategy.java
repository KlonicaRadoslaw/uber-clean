package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Strategy 1
/**
 * Interfejs strategii naliczania punktów.
 */
public interface PointsStrategy {
    int calculatePoints(double amountSpent);
}
// Koniec, Tydzień 6, Wzorzec Strategy 1