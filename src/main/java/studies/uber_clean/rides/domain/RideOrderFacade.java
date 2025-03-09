package studies.uber_clean.rides.domain;

import java.time.LocalDateTime;
import java.util.List;

public class RideOrderFacade {
    private final RideOrderRepository rideOrderRepository;

    public RideOrderFacade(RideOrderRepository rideOrderRepository) {
        this.rideOrderRepository = rideOrderRepository;
    }

    public RideOrder createRideOrder(String customerEmail, String driverEmail, String pickupLocation, String destination, boolean isPremium, double price, LocalDateTime rideDate) {
        RideOrder rideOrder = new RideOrderBuilder()
                .withCustomer(customerEmail)
                .withDriver(driverEmail)
                .withPickupLocation(pickupLocation)
                .withDestination(destination)
                .asPremium(isPremium)
                .withPrice(price)
                .withRideDate(rideDate)
                .build();

        return rideOrderRepository.save(rideOrder);
    }

    public List<RideOrder> getAllRideOrders() {
        List<RideOrder> rideOrders = rideOrderRepository.findAll();
        rideOrders.forEach(ride -> System.out.println(ride.getOrderId()));
        return rideOrders;
    }
}
