package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Observer 2
// Zarządza obserwatorami i publikuje do nich nowe przejazdy
class RideDataPublisher {
    private final List<RideObserver> observers = new ArrayList<>();

    public void attach(RideObserver observer) {
        observers.add(observer);
    }

    public void publish(Ride ride) {
        for (RideObserver observer : observers) {
            observer.update(ride);
        }
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 2