package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Visitor 1
/**
 * Interfejs użytkowników odwiedzanych przez Visitor
 */
public interface VisitableUser {
    void accept(LoyaltyVisitor visitor);
}
// Koniec, Tydzień 6, Wzorzec Visitor 1