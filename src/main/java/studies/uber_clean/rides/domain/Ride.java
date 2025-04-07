package studies.uber_clean.rides.domain;

import jakarta.persistence.*;
import studies.uber_clean.rideAnalytics.domain.RideVisitor;

// Tydzień 1, Wzorzec Prototype 1
// Klasa Ride może sklonować istniejący przejazd
@Entity
public class Ride implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long rideId;

    protected String pickupLocation;
    protected String destination;
    protected Integer tripTimeInSeconds;
    protected String cost;
    protected boolean isPremium;

    public Ride(String pickupLocation, String destination, Integer tripTimeInSeconds, String cost, boolean isPremium) {
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.tripTimeInSeconds = tripTimeInSeconds;
        this.cost = cost;
        this.isPremium = isPremium;
    }

    public Ride() {}

    public Long getRideId() {
        return rideId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getTripTimeInSeconds() {
        return tripTimeInSeconds;
    }

    public String getCost() {
        return cost;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @Override
    public Ride clone() {
        try {
            return (Ride) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    // Tydzień 6, Wzorzec Visitor 2
    public String accept(RideVisitor visitor) {
        return visitor.visit(this);
    }
    // Koniec, Tydzień 6, Wzorzec Visitor 2

}
// Koniec, Tydzień 1, Wzorzec Prototype 1