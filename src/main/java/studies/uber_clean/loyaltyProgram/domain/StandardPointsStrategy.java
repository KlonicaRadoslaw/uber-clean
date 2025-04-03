package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Strategy 1
/**
 * Standardowa strategia naliczania punktów.
 */
public class StandardPointsStrategy implements PointsStrategy {
    @Override
    public int calculatePoints(double amountSpent) {
        return (int) (amountSpent * 10);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 1