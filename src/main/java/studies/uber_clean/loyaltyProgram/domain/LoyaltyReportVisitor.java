package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Visitor 1

import studies.uber_clean.users.domain.Customer;
import studies.uber_clean.users.domain.Driver;

/**
 * Implementacja Visitor dla raportowania nagród lojalnościowych
 */
class LoyaltyReportVisitor implements LoyaltyVisitor {
    private String report;

    @Override
    public void visit(Customer customer) {
        System.out.println("Generating loyalty report for Customer: " + customer.getEmail());
    }

    @Override
    public void visit(Driver driver) {
        System.out.println("Generating loyalty report for Driver: " + driver.getEmail());
    }

    public void visit(LoyaltyAccount account) {
        report = "User has " + account.getPoints() + " points and is on " + account.getLevelName() + " level.";
    }

    public String getReport() {
        return report;
    }
}
// Koniec, Tydzień 6, Wzorzec Visitor 1