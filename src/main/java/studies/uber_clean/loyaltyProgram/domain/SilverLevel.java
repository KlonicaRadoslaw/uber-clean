package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 7, Wzorzec Single responsibility 1
// Tydzień 6, Wzorzec State 1
/**
 * Klasa reprezentująca poziom Silver.
 */

public class SilverLevel extends LoyaltyLevel {

    private final SilverToGoldPromotionRule promotionRule = new SilverToGoldPromotionRule();

    @Override
    public String getLevelName() {
        return "Silver";
    }

    @Override
    public void checkForUpgrade(LoyaltyAccount account) {
        if (promotionRule.shouldPromote(account)) {
            account.upgradeLevel();
        }
    }

    @Override
    public LoyaltyLevel nextLevel() {
        return new GoldLevel();
    }
}
// Koniec, Tydzień 6, Wzorzec State 1
// Koniec, Tydzień 7, Wzorzec Single responsibility 1