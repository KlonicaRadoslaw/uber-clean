package studies.uber_clean.vehicles.domain;

// Tydzień 1, Wzorzec Builder 2
// Klasa VehicleBuilder może budować dowolny pojazd
public class VehicleBuilder {
    private String manufacturer;
    private String model;

    public VehicleBuilder setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public VehicleBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public Car buildCar(String vin, int manufacturingYear, int seats) {
        return new Car(manufacturer, model, vin, manufacturingYear, seats);
    }

    public Bike buildBike(boolean haveBasket) {
        return new Bike(manufacturer, model, haveBasket);
    }

    public Scooter buildScooter(int maxSpeed, int maxRangeOnSingleCharge) {
        return new Scooter(manufacturer, model, maxSpeed, maxRangeOnSingleCharge);
    }
}
// Koniec, Tydzień 1, Wzorzec Builder 2