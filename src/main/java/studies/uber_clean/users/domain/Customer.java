package studies.uber_clean.users.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import studies.uber_clean.loyaltyProgram.domain.LoyaltyVisitor;
import studies.uber_clean.loyaltyProgram.domain.VisitableUser;

// Tydzień 1, Wzorzec Factory 1
@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User implements VisitableUser {
    @Enumerated(EnumType.STRING)
    protected CustomerType customerType;

    public Customer() {}

    public Customer(String email, String password, String phoneNumber, CustomerType customerType) {
        super(email, password, phoneNumber);
        this.customerType = customerType;
    }

    // Tydzień 6, Wzorzec Visitor 1
    @Override
    public void accept(LoyaltyVisitor visitor) {
        visitor.visit(this);
    }
    // Koniec, Tydzień 6, Wzorzec Visitor 1
}
// Koniec, Tydzień 1, Wzorzec Factory 1