package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Strategy 1
/**
 * Standardowa strategia naliczania punktów.
 */
public class StandardPointsStrategy implements PointsStrategy {
    // Tydzień 9, Magic numbers
    private static final int POINTS_MULTIPLIER = 10;
    // Koniec, Tydzień 9, Magic numbers

    @Override
    public int calculatePoints(double amountSpent) {
        return (int) (amountSpent * POINTS_MULTIPLIER);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 1