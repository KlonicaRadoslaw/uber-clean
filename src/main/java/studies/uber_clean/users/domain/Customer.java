package studies.uber_clean.users.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CUSTOMER")
@NoArgsConstructor
public class Customer extends User {
    @Enumerated(EnumType.STRING)
    protected CustomerType customerType;

    public Customer(String email, String password, CustomerType customerType) {
        super(email, password);
        this.customerType = customerType;
    }
}
