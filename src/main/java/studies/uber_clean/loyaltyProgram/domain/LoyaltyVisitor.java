package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Visitor 1

import studies.uber_clean.users.domain.Customer;
import studies.uber_clean.users.domain.Driver;

/**
 * Visitor - Interfejs odwiedzający użytkownika w programie lojalnościowym
 */
public interface LoyaltyVisitor {
    void visit(Customer customer);
    void visit(Driver driver);
}
// Koniec, Tydzień 6, Wzorzec Visitor 1