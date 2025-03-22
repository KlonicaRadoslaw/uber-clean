package studies.uber_clean.vehicles.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import studies.uber_clean.vehicles.dto.responses.BikeDetailedResponse;

// Tydzień 1, Wzorzec Prototype 2
// Klasa Bike może sklonować istniejący rower
@Entity
@DiscriminatorValue("BIKE")
public class Bike extends Vehicle implements Cloneable {
    protected boolean haveBasket;

    public Bike() {
        super();
    }

    public Bike(String brand, String model, boolean haveBasket) {
        super(brand, model);
        this.haveBasket = haveBasket;
    }

    @Override
    public Bike clone() {
        try {
            return (Bike) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    public static BikeDetailedResponse toDetailedResponse(Bike bike) {
        return new BikeDetailedResponse(bike.getVehicleId(), bike.manufacturer, bike.model, bike.isAssigned(), bike.haveBasket);
    }

    public boolean doesHaveBasket() {
        return haveBasket;
    }
}
// Koniec Tydzień 1, Wzorzec Prototype 1
