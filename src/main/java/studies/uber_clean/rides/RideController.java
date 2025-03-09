package studies.uber_clean.rides;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.rides.domain.Ride;
import studies.uber_clean.rides.domain.RideFacade;
import studies.uber_clean.rides.dto.requests.RideRequest;
import studies.uber_clean.rides.dto.responses.RideResponse;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {
    private final RideFacade rideFacade;

    public RideController(RideFacade rideFacade) {
        this.rideFacade = rideFacade;
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideFacade.getAllRides();
    }

    @PostMapping
    public RideResponse createRide(@RequestBody RideRequest request) {
        return rideFacade.createRide(request);
    }

    @PostMapping("/{rideId}/repeat")
    public RideResponse repeatRide(@PathVariable Long rideId, @RequestParam String newPickupLocation) {
        return rideFacade.repeatRide(rideId, newPickupLocation);
    }
}