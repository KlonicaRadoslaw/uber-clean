package studies.uber_clean.rides.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// Tydzień 1, Wzorzec Builder 1
// Klasa RideOrder to klasa bazowa do budowania zamówienia przejazdu
@Entity
public class RideOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long orderId;

    protected String customerEmail;
    protected String driverEmail;
    protected String pickupLocation;
    protected String destination;
    protected boolean isPremium;
    protected double price;
    protected LocalDateTime rideDate;

    public RideOrder(String customerEmail, String driverEmail, String pickupLocation, String destination, boolean isPremium, double price, LocalDateTime rideDate) {
        this.customerEmail = customerEmail;
        this.driverEmail = driverEmail;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.isPremium = isPremium;
        this.price = price;
        this.rideDate = rideDate;
    }

    public RideOrder() {}

    public Long getOrderId() {
        return orderId;
    }
}
// Koniec, Tydzień 1, Wzorzec Builder 1