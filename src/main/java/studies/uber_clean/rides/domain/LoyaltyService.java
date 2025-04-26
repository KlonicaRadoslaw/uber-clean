package studies.uber_clean.rides.domain;

// Tydzień 8, Wzorzec Dependency Invertion 3
// DIP - Klasa wyższego poziomu
public class LoyaltyService {
    private final RewardCalculator rewardCalculator;

    public LoyaltyService(RewardCalculator rewardCalculator) {
        this.rewardCalculator = rewardCalculator;
    }

    public int rewardPointsForRide(double rideCost) {
        return rewardCalculator.calculateRewardPoints(rideCost);
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 3