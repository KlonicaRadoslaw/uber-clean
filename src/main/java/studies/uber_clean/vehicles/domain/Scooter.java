package studies.uber_clean.vehicles.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Tydzień 1, Wzorzec Prototype 3
@Getter
@Setter
@Entity
@DiscriminatorValue("SCOOTER")
public class Scooter extends Vehicle implements Cloneable {
    private int maxSpeed;
    private int maxRangeOnSingleCharge;
    public Scooter() {}

    public Scooter(String brand, String model, int maxSpeed, int maxRangeOnSingleCharge) {
        super(brand, model);
        this.maxSpeed = maxSpeed;
        this.maxRangeOnSingleCharge = maxRangeOnSingleCharge;
    }

    @Override
    public Scooter clone() {
        try {
            return (Scooter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}
// Koniec, Tydzień 1, Wzorzec Prototype 3