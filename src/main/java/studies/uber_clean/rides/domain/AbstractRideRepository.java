package studies.uber_clean.rides.domain;

// Tydzień 8, Wzorzec Dependency Invertion 2
// DIP - Klasa abstrakcyjna
public abstract class AbstractRideRepository {
    public abstract Ride saveRide(Ride ride);
    public abstract Ride findRideById(Long id);
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 2