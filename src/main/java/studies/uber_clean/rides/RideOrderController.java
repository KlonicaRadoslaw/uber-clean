package studies.uber_clean.rides;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.rides.domain.RideOrder;
import studies.uber_clean.rides.domain.RideOrderFacade;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ride-orders")
public class RideOrderController {
    private final RideOrderFacade rideOrderFacade;

    public RideOrderController(RideOrderFacade rideOrderFacade) {
        this.rideOrderFacade = rideOrderFacade;
    }

    @GetMapping
    public List<RideOrder> getAllRideOrders() {
        return rideOrderFacade.getAllRideOrders();
    }

    @PostMapping
    public RideOrder createRideOrder(
            @RequestParam String customerEmail,
            @RequestParam String driverEmail,
            @RequestParam String pickupLocation,
            @RequestParam String destination,
            @RequestParam boolean isPremium,
            @RequestParam double price,
            @RequestParam String rideDate) {

        LocalDateTime dateTime = LocalDateTime.parse(rideDate);

        return rideOrderFacade.createRideOrder(customerEmail, driverEmail, pickupLocation, destination, isPremium, price, dateTime);
    }
}
