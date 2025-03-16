package studies.uber_clean.users.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import studies.uber_clean.vehicles.domain.Vehicle;

// Tydzień 1, Wzorzec Factory 1
@Entity
@DiscriminatorValue("DRIVER")
@Getter
public class Driver extends User {
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
}
// Koniec, Tydzień 1, Wzorzec Factory 1