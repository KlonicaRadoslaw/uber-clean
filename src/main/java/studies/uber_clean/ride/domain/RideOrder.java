package studies.uber_clean.ride.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Tydzień 1, Wzorzec Builder 1
// Klasa RideOrder to klasa bazowa do budowania zamówienia przejazdu
@Entity
public class RideOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;

    private String customerEmail;
    private String driverEmail;
    private String pickupLocation;
    private String destination;
    private boolean isPremium;
    private double price;
    private LocalDateTime rideDate;

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
//Koniec, Tydzień 1, Wzorzec Builder 1