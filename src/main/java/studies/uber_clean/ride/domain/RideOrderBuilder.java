package studies.uber_clean.ride.domain;

import java.time.LocalDateTime;

//Tydzień 1, Wzorzec Builder 1
// Klasa RideOrderBuilder może budować zamówienie przejazdu
public class RideOrderBuilder {
    private String customerEmail;
    private String driverEmail;
    private String pickupLocation;
    private String destination;
    private boolean isPremium;
    private double price;
    private LocalDateTime rideDate;

    public RideOrderBuilder withCustomer(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public RideOrderBuilder withDriver(String driverEmail) {
        this.driverEmail = driverEmail;
        return this;
    }

    public RideOrderBuilder withPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
        return this;
    }

    public RideOrderBuilder withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public RideOrderBuilder asPremium(boolean isPremium) {
        this.isPremium = isPremium;
        return this;
    }

    public RideOrderBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public RideOrderBuilder withRideDate(LocalDateTime rideDate) {
        this.rideDate = rideDate;
        return this;
    }

    public RideOrder build() {
        return new RideOrder(customerEmail, driverEmail, pickupLocation, destination, isPremium, price, rideDate);
    }
}
//Koniec, Tydzień 1, Wzorzec Builder 1