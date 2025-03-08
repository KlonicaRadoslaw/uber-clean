package studies.uber_clean.ride.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Tydzień 1, Wzorzec Prototype 1
// Klasa Ride może sklonować istniejący przejazd
@Entity
public class Ride implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rideId;

    private String pickupLocation;
    private String destination;
    private boolean isPremium;

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

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
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
//Koniec, Tydzień 1, Wzorzec Prototype 1