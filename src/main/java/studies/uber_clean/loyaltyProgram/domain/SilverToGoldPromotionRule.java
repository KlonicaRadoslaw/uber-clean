package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 7, Wzorzec Single responsibility 1

/**
 * Reguła awansu na poziom Gold.
 */
public class SilverToGoldPromotionRule {
    // Tydzień 9, Magic numbers
    private static final int MIN_POINTS_TO_UPDATE = 1000;
    // Koniec, Tydzień 9, Magic numbers
    public boolean shouldPromote(LoyaltyAccount account) {
        return account.getPoints() >= MIN_POINTS_TO_UPDATE;
    }
}
// Koniec, Tydzień 7, Wzorzec Single responsibility 1