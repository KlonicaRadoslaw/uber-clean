package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Template 1
// Tydzień 7, Wzorzec Open Closed 1
/**
 * Wzorzec Template Method: Definiuje szablon przyznawania nagród.
 */
public abstract class LoyaltyRewardTemplate {

    public final void grantReward(LoyaltyAccount account) {
        if (isEligible(account)) {
            applyReward(account);
            notifyUser(account);
        } else {
            System.out.println("Użytkownik " + account.getUser().getEmail() + " nie kwalifikuje się do nagrody.");
        }
    }

    protected abstract boolean isEligible(LoyaltyAccount account);
    protected abstract void applyReward(LoyaltyAccount account);

    private void notifyUser(LoyaltyAccount account) {
        System.out.println("Nagroda została przyznana użytkownikowi: " + account.getUser().getEmail());
    }
}
// Koniec, Tydzień 6, Wzorzec Template 1
// Koniec, Tydzień 7, Wzorzec Open Closed 1