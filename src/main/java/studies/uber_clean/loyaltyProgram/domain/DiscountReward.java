package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Template 1
/**
 * Konkretna nagroda: Zniżka na przejazd.
 */
public class DiscountReward extends LoyaltyRewardTemplate {

    @Override
    protected boolean isEligible(LoyaltyAccount account) {
        return account.getPoints() >= 100;
    }

    @Override
    protected void applyReward(LoyaltyAccount account) {
        account.setPoints(account.getPoints() - 100);
        System.out.println("Użytkownik " + account.getUser().getEmail() + " otrzymał 10% zniżki na kolejny przejazd!");
    }
}
// Koniec, Tydzień 6, Wzorzec Template 1