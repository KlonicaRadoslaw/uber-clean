package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec State 1
/**
 * Abstrakcyjna klasa reprezentująca poziom lojalnościowy użytkownika.
 * Wykorzystuje wzorzec **State**.
 */
public abstract class LoyaltyLevel {
    public abstract String getLevelName();
    public abstract void checkForUpgrade(LoyaltyAccount account);
    public abstract LoyaltyLevel nextLevel();
}
// Koniec, Tydzień 6, Wzorzec State 1