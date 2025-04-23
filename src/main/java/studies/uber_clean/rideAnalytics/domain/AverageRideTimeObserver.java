package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Observer 2
// Obserwator aktualizujacy czas
// Tydzień 7, Wzorzec Single responsibility 2
class AverageRideTimeObserver implements RideObserver {
    @Override
    public void update(Ride ride) {
        System.out.println("[Observer] Updated average time with ride: " + ride.getTripTimeInSeconds());
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 2
// Koniec, Tydzień 7, Wzorzec Single responsibility 2