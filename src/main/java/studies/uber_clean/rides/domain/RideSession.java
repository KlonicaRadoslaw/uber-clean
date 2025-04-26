package studies.uber_clean.rides.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// Tydzień 1, Wzorzec Singleton 1
// Klasa do śledzenia sesji przejazdów. Tylko jedna instancja do przechowywania wszytkich przejazdów w seji
public class RideSession {
    private static RideSession instance;
    private final Map<Long, RideOrder> activeRides;


    public RideSession() {
        activeRides = new HashMap<>();
    }

    public static synchronized RideSession getInstance() {
        if (instance == null) {
            instance = new RideSession();
        }
        return instance;
    }

    public void addActiveRide(String customerEmail, String driverEmail, String startLocation,
                              String endLocation, boolean isFoodDelivery, double price,
                              LocalDateTime rideDate) {
        RideOrder newRide = RideFactory.createRide(customerEmail, driverEmail, startLocation, endLocation,
                isFoodDelivery, price, rideDate);
        activeRides.put(newRide.getOrderId(), newRide);
    }

    public void removeActiveRide(Long orderId) {
        activeRides.remove(orderId);
    }

    public RideOrder getActiveRide(Long orderId) {
        return activeRides.get(orderId);
    }

    public Map<Long, RideOrder> getAllActiveRides() {
        return activeRides;
    }
}
// Koniec, Tydzień 1, Wzorzec Singleton 1