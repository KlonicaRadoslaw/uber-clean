package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec State 1
/**
 * Klasa reprezentująca poziom Gold.
 */
public class GoldLevel extends LoyaltyLevel {

    @Override
    public String getLevelName() {
        return "Gold";
    }

    @Override
    public void checkForUpgrade(LoyaltyAccount account) {
        // Maksymalny poziom
    }

    @Override
    public LoyaltyLevel nextLevel() {
        return this;
    }
}
// Koniec, Tydzień 6, Wzorzec State 1