package studies.uber_clean.rides.domain;

import studies.uber_clean.rides.dto.requests.RideRequest;
import studies.uber_clean.rides.dto.responses.RideResponse;

import java.util.List;

// Tydzień 4, Wzorzec Facade 2
public class RideFacade {
    private final RideRepository rideRepository;

    public RideFacade(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public RideResponse createRide(RideRequest request) {
        Ride ride = new Ride(request.pickupLocation, request.destination, request.isPremium);
        Ride savedRide = rideRepository.save(ride);
        return new RideResponse(savedRide.getRideId(), savedRide.getPickupLocation(), savedRide.getDestination(), savedRide.isPremium());
    }

    public RideResponse repeatRide(Long rideId, String newPickupLocation) {
        Ride existingRide = rideRepository.findById(rideId)
                .orElseThrow(() -> new IllegalArgumentException("Ride not found"));

        Ride clonedRide = existingRide.clone();
        clonedRide.setPickupLocation(newPickupLocation);
        Ride savedRide = rideRepository.save(clonedRide);

        return new RideResponse(savedRide.getRideId(), savedRide.getPickupLocation(), savedRide.getDestination(), savedRide.isPremium());
    }

    public List<Ride> getAllRides() {
        List<Ride> rides = rideRepository.findAll();
        rides.forEach(ride -> System.out.println(ride.getRideId()));
        return rides;
    }
}
// Koniec, Tydzień 4, Wzorzec Facade 2