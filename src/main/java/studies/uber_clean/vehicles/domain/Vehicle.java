package studies.uber_clean.vehicles.domain;

import jakarta.persistence.*;
import lombok.Setter;

import java.io.Serializable;

// Tydzień 1, Wzorzec Factory 3
// Na klasie Vehicle bazują klasy Bike, Car, Scooter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long vehicleId;

    protected String manufacturer;
    protected String model;
    private boolean isAssigned;

    public Vehicle() {}

    public Vehicle(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.isAssigned = false;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }
}
// Koniec, Tydzień 1, Wzorzec Factory 3
