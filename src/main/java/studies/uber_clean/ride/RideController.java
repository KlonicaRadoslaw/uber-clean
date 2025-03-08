package studies.uber_clean.ride;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.ride.domain.Ride;
import studies.uber_clean.ride.domain.RideFacade;
import studies.uber_clean.ride.dto.requests.RideRequest;
import studies.uber_clean.ride.dto.responses.RideResponse;
import studies.uber_clean.users.domain.User;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {
    private final RideFacade rideFacade;

    public RideController(RideFacade rideFacade) {
        this.rideFacade = rideFacade;
    }

    @GetMapping
    public List<Ride> getAllUsers() {
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