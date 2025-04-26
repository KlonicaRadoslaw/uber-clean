package studies.uber_clean.rides.domain;

// Tydzień 8, Wzorzec Dependency Invertion 2
// DIP - Implementacja
public class InMemoryRideRepository extends AbstractRideRepository {
    @Override
    public Ride saveRide(Ride ride) {
        System.out.println("Saving ride to in-memory database...");
        return ride;
    }

    @Override
    public Ride findRideById(Long id) {
        System.out.println("Finding ride in in-memory database...");
        return new Ride("customer@example.com", "driver@example.com");
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 2