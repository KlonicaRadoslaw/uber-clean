package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Observer 2
// Obserwator aktualizujący miejsca docelowe
class PopularDestinationsObserver implements RideObserver {
    @Override
    public void update(Ride ride) {
        System.out.println("[Observer] Noted destination: " + ride.getDestination());
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 2