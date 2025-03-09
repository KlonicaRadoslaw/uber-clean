package studies.uber_clean.rides;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.rides.domain.RideOrder;
import studies.uber_clean.rides.domain.RideSession;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/rides")
public class RideSessionController {

    private final RideSession rideSession = RideSession.getInstance();

    // Dodanie przejazdu do aktywnej sesji
    @PostMapping("/add")
    public String addRide(@RequestParam String customerEmail,
                          @RequestParam String driverEmail,
                          @RequestParam String startLocation,
                          @RequestParam String endLocation,
                          @RequestParam boolean isFoodDelivery,
                          @RequestParam double price,
                          @RequestParam String rideDate) {

        LocalDateTime rideDateTime = LocalDateTime.parse(rideDate);

        rideSession.addActiveRide(customerEmail, driverEmail, startLocation, endLocation,
                isFoodDelivery, price, rideDateTime);
        return "Ride added to active session!";
    }

    @GetMapping("/active")
    public Map<Long, RideOrder> getAllActiveRides() {
        return rideSession.getAllActiveRides();
    }

    @GetMapping("/active/{orderId}")
    public RideOrder getActiveRide(@PathVariable Long orderId) {
        return rideSession.getActiveRide(orderId);
    }

    @DeleteMapping("/remove/{orderId}")
    public String removeRide(@PathVariable Long orderId) {
        rideSession.removeActiveRide(orderId);
        return "Ride removed from active session!";
    }
}
