package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Observer 2
// Obserwator aktualizujący miejsca docelowe
// Tydzień 7, Wzorzec Single responsibility 2
class PopularDestinationsObserver implements RideObserver {
    @Override
    public void update(Ride ride) {
        System.out.println("[Observer] Noted destination: " + ride.getDestination());
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 2
// Koniec, Tydzień 7, Wzorzec Single responsibility 2