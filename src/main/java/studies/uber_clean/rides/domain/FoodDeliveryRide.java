package studies.uber_clean.rides.domain;

import jakarta.persistence.Entity;

// Tydzień 8, Wzorzec Liskov 2
// LSP - Klasa pochodna
@Entity
public class FoodDeliveryRide extends Ride {
    private String restaurantName;

    public FoodDeliveryRide() {}

    public FoodDeliveryRide(String destination, String pickupLocation, String restaurantName) {
        super(destination, pickupLocation);
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}
// Koniec, Tydzień 8, Wzorzec Liskov 2