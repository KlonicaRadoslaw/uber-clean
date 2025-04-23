package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Observer 2
// Zarządza obserwatorami i publikuje do nich nowe przejazdy
class RidePublisher {
    private final RideObserverRegistry registry;

    public RidePublisher(RideObserverRegistry registry) {
        this.registry = registry;
    }

    public void publish(Ride ride) {
        for (RideObserver observer : registry.getObservers()) {
            observer.update(ride);
        }
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 2