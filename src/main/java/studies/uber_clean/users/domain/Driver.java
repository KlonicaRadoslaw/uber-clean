package studies.uber_clean.users.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import studies.uber_clean.loyaltyProgram.domain.LoyaltyVisitor;
import studies.uber_clean.loyaltyProgram.domain.VisitableUser;
import studies.uber_clean.vehicles.domain.Vehicle;

// Tydzień 1, Wzorzec Factory 1
@Entity
@DiscriminatorValue("DRIVER")
@Getter
public class Driver extends User implements VisitableUser {
    protected String licenseId;
    protected Vehicle assignedVehicle = null;

    public Driver() {
        super();
    }

    public Driver(String email, String password, String phoneNumber, String licenseId) {
        super(email, password, phoneNumber);
        this.licenseId = licenseId;
    }

    public void setAssignedVehicle(Vehicle assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    // Tydzień 6, Wzorzec Visitor 1
    @Override
    public void accept(LoyaltyVisitor visitor) {
            visitor.visit(this);
    }
    // Koniec, Tydzień 6, Wzorzec Visitor 1
}
// Koniec, Tydzień 1, Wzorzec Factory 1