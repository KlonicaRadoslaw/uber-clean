package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 7, Wzorzec Single responsibility 1

/**
 * Reguła awansu na poziom Gold.
 */
public class SilverToGoldPromotionRule {
    public boolean shouldPromote(LoyaltyAccount account) {
        return account.getPoints() >= 1000;
    }
}
// Koniec, Tydzień 7, Wzorzec Single responsibility 1