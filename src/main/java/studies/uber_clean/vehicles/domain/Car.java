package studies.uber_clean.vehicles.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Tydzień 1, Wzorzec Factory 1
// Tydzień 8, Wzorzec Liskov 5
// Klasa pochodna
@Getter
@Setter
@Entity
@DiscriminatorValue("CAR")
public class Car extends Vehicle {
    private String vin;
    private int manufacturingYear;
    private int seats;

    public Car() {}

    public Car(String brand, String model, String vin, int manufacturingYear, int seats) {
        super(brand, model);
        this.manufacturingYear = manufacturingYear;
        this.seats = seats;
        this.vin = vin;
    }

    public int getSeats() {
        return seats;
    }
}
// Koniec, Tydzień 1, Wzorzec Factory
// Koniec, Tydzień 8, Wzorzec Liskov 5
