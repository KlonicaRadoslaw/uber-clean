package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec State 1
/**
 * Klasa reprezentująca poziom Silver.
 */
public class SilverLevel extends LoyaltyLevel {

    @Override
    public String getLevelName() {
        return "Silver";
    }

    @Override
    public void checkForUpgrade(LoyaltyAccount account) {
        if (account.getPoints() >= 1000) {
            account.upgradeLevel();
        }
    }

    @Override
    public LoyaltyLevel nextLevel() {
        return new GoldLevel();
    }
}
// Koniec, Tydzień 6, Wzorzec State 1