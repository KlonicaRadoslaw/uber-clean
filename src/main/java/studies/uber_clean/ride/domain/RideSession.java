package studies.uber_clean.ride.domain;

import java.util.HashMap;
import java.util.Map;

public class RideSession {
    private static RideSession instance;
    private Map<Long, RideOrder> activeRides;

    private RideSession() {
        activeRides = new HashMap<>();
    }

    public static synchronized RideSession getInstance() {
        if (instance == null) {
            instance = new RideSession();
        }
        return instance;
    }

    public void addActiveRide(RideOrder rideOrder) {
        activeRides.put(rideOrder.getOrderId(), rideOrder);
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
