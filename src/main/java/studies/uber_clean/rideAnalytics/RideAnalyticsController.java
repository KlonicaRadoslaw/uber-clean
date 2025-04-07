package studies.uber_clean.rideAnalytics;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.rideAnalytics.domain.RideAnalyticsFacade;
import studies.uber_clean.rides.domain.Ride;

@RestController
@RequestMapping("/ride-analytics")
public class RideAnalyticsController {
    private final RideAnalyticsFacade rideAnalyticsFacade;

    public RideAnalyticsController(RideAnalyticsFacade rideAnalyticsFacade) {
        this.rideAnalyticsFacade = rideAnalyticsFacade;
    }

    @PostMapping("/new-ride")
    public String newRide(@RequestBody Ride ride) {
        rideAnalyticsFacade.processNewRide(ride);
        return "Ride processed.";
    }

    @GetMapping("/analyze/{rideId}")
    public String runAnalysis(@RequestParam String strategy, @PathVariable Long rideId) {
        return rideAnalyticsFacade.runStrategy(strategy, rideId);
    }

    @GetMapping("/visit/{rideId}")
    public String visitRide(@RequestParam String type, @PathVariable Long rideId) {
        return rideAnalyticsFacade.visitRideData(type, rideId);
    }
}