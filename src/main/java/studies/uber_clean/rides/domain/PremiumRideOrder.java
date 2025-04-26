package studies.uber_clean.rides.domain;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
// Tydzień 8, Wzorzec Liskov 1
// LSP - Klasa pochodna
@Entity
public class PremiumRideOrder extends RideOrder {
    private boolean includesChampagne;

    public PremiumRideOrder(String customerEmail, String driverEmail, String pickupLocation, String destination,
                            double price, LocalDateTime rideDate, boolean includesChampagne) {
        super(customerEmail, driverEmail, pickupLocation, destination, true, price, rideDate);
        this.includesChampagne = includesChampagne;
    }

    public PremiumRideOrder() {}

    public boolean isIncludesChampagne() {
        return includesChampagne;
    }
}
// Koniec, Tydzień 8, Wzorzec Liskov 1