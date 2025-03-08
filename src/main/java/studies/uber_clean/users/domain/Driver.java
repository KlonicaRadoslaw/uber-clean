package studies.uber_clean.users.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
//Tydzień 1, Wzorzec Factory 1
@Entity
@DiscriminatorValue("DRIVER")
public class Driver extends User {
    protected String licenseId = null;

    public Driver() {
        super();
    }

    public Driver(String email, String password) {
        super(email, password);
    }

}
//Koniec, Tydzień 1, Wzorzec Factory 1