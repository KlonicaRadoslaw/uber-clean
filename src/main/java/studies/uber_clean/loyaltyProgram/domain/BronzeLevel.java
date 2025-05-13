package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec State 1
/**
 * Klasa reprezentująca poziom Bronze.
 */
public class BronzeLevel extends LoyaltyLevel {
    // Tydzień 9, Magic numbers
    private static final int MIN_POINTS_TO_UPDATE = 500;
    // Koniec, Tydzień 9, Magic numbers

    @Override
    public String getLevelName() {
        return "Bronze";
    }

    @Override
    public void checkForUpgrade(LoyaltyAccount account) {
        if (account.getPoints() >= MIN_POINTS_TO_UPDATE) {
            account.upgradeLevel();
        }
    }

    @Override
    public LoyaltyLevel nextLevel() {
        return new SilverLevel();
    }
}
// Koniec, Tydzień 6, Wzorzec State 1