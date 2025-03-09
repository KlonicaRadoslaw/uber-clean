package studies.uber_clean.rides.domain;

import java.time.LocalDateTime;

// Tydzień 1, Wzorzec Factory 2
// Klasa ta wytwarza obiekty przejazdu zależnie od typu.
// Przewóz osób lub jedzenia (uber eats)
public class RideFactory {
    public static RideOrder createRide(String customerEmail, String driverEmail, String startLocation,
                                       String endLocation, boolean isFoodDelivery, double price,
                                       LocalDateTime rideDate) {

        // W zależności od typu przejazdu, tworzony jest odpowiedni obiekt
        return new RideOrder(customerEmail, driverEmail, startLocation, endLocation, isFoodDelivery, price, rideDate);
    }
}
// Koniec, Tydzień 1, Wzorzec Factory 2