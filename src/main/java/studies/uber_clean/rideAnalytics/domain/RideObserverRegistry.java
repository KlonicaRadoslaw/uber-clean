package studies.uber_clean.rideAnalytics.domain;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Observer 2
// Zarządza obserwatorami i publikuje do nich nowe przejazdy
class RideObserverRegistry {
    private final List<RideObserver> observers = new ArrayList<>();

    public void register(RideObserver observer) {
        observers.add(observer);
    }

    public List<RideObserver> getObservers() {
        return observers;
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 2