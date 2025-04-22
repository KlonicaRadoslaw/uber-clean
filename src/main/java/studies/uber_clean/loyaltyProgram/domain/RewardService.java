package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 7, Wzorzec Single responsibility 1
/**
 * Przyznaje nagrody lojalnościowe.
 */
public class RewardService {

    public void grantDiscountReward(LoyaltyAccount account) {
        new DiscountReward().grantReward(account);
    }

    public void grantFreeRideReward(LoyaltyAccount account) {
        new FreeRideReward().grantReward(account);
    }
}
// Koniec, Tydzień 7, Wzorzec Single responsibility 1