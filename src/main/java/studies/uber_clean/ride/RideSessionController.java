package studies.uber_clean.ride;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.ride.domain.RideOrder;
import studies.uber_clean.ride.domain.RideSession;

import java.util.Map;

@RestController
@RequestMapping("/rides")
public class RideSessionController {

    private final RideSession rideSession = RideSession.getInstance();

    // Dodanie przejazdu do aktywnej sesji
    @PostMapping("/add")
    public String addRide(@RequestBody RideOrder rideOrder) {
        rideSession.addActiveRide(rideOrder);
        return "Ride added to active session!";
    }

    @GetMapping("/active")
    public Map<Long, RideOrder> getAllActiveRides() {
        return rideSession.getAllActiveRides();
    }

    // Usunięcie przejazdu z aktywnej sesji
    @DeleteMapping("/remove/{orderId}")
    public String removeRide(@PathVariable Long orderId) {
        rideSession.removeActiveRide(orderId);
        return "Ride removed from active session!";
    }
}
