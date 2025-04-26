package studies.uber_clean.rides.domain;

// Tydzień 8, Wzorzec Dependency Invertion 3
// DIP - Implementacja
public class BasicRewardCalculator implements RewardCalculator {
    @Override
    public int calculateRewardPoints(double amountSpent) {
        return (int) (amountSpent / 10); // 1 punkt za każde 10 zł
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 3