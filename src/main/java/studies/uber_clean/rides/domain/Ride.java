package studies.uber_clean.rides.domain;

import jakarta.persistence.*;

// Tydzień 1, Wzorzec Prototype 1
// Klasa Ride może sklonować istniejący przejazd
@Entity
public class Ride implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long rideId;

    protected String pickupLocation;
    protected String destination;
    protected boolean isPremium;

    public Ride(String pickupLocation, String destination, boolean isPremium) {
        this.pickupLocation = pickupLocation;
        this.destination = destination;
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
}
// Koniec, Tydzień 1, Wzorzec Prototype 1