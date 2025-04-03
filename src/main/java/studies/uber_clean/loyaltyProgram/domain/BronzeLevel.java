package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec State 1
/**
 * Klasa reprezentująca poziom Bronze.
 */
public class BronzeLevel extends LoyaltyLevel {

    @Override
    public String getLevelName() {
        return "Bronze";
    }

    @Override
    public void checkForUpgrade(LoyaltyAccount account) {
        if (account.getPoints() >= 500) {
            account.upgradeLevel();
        }
    }

    @Override
    public LoyaltyLevel nextLevel() {
        return new SilverLevel();
    }
}
// Koniec, Tydzień 6, Wzorzec State 1