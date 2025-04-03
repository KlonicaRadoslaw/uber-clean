package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Template 1
/**
 * Konkretna nagroda: Darmowy przejazd.
 */
public class FreeRideReward extends LoyaltyRewardTemplate {

    @Override
    protected boolean isEligible(LoyaltyAccount account) {
        return account.getPoints() >= 500;
    }

    @Override
    protected void applyReward(LoyaltyAccount account) {
        account.setPoints(account.getPoints() - 500);
        System.out.println("Użytkownik " + account.getUser().getEmail() + " otrzymał darmowy przejazd!");
    }
}
// Koniec, Tydzień 6, Wzorzec Template 1