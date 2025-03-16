package studies.uber_clean.users.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

// Tydzień 1, Wzorzec Factory 1
@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {
    @Enumerated(EnumType.STRING)
    protected CustomerType customerType;

    public Customer() {}

    public Customer(String email, String password, String phoneNumber, CustomerType customerType) {
        super(email, password, phoneNumber);
        this.customerType = customerType;
    }
}
// Koniec, Tydzień 1, Wzorzec Factory 1