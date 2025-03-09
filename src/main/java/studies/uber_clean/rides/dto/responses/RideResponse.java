package studies.uber_clean.rides.dto.responses;

public class RideResponse {
    public Long rideId;
    public String pickupLocation;
    public String destination;
    public boolean isPremium;

    public RideResponse(Long rideId, String pickupLocation, String destination, boolean isPremium) {
        this.rideId = rideId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.isPremium = isPremium;
    }
}
