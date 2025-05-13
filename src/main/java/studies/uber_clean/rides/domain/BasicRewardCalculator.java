package studies.uber_clean.rides.domain;

// Tydzień 8, Wzorzec Dependency Invertion 3
// DIP - Implementacja
public class BasicRewardCalculator implements RewardCalculator {
    // Tydzień 9, Magic numbers
    private static final int POINTS_MULTIPLIER = 10;
    // Koniec, Tydzień 9, Magic numbers

    @Override
    public int calculateRewardPoints(double amountSpent) {
        return (int) (amountSpent / POINTS_MULTIPLIER); // 1 punkt za każde 10 zł
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 3