package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Template 1
/**
 * Konkretna nagroda: Zniżka na przejazd.
 */
public class DiscountReward extends LoyaltyRewardTemplate {
    // Tydzień 9, Magic numbers
    private static final int MIN_POINTS_TO_APPLY_REWARD = 100;
    // Koniec, Tydzień 9, Magic numbers


    @Override
    protected boolean isEligible(LoyaltyAccount account) {
        return account.getPoints() >= MIN_POINTS_TO_APPLY_REWARD;
    }

    @Override
    protected void applyReward(LoyaltyAccount account) {
        account.setPoints(account.getPoints() - MIN_POINTS_TO_APPLY_REWARD);
        System.out.println("Użytkownik " + account.getUser().getEmail() + " otrzymał 10% zniżki na kolejny przejazd!");
    }
}
// Koniec, Tydzień 6, Wzorzec Template 1