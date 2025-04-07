package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec State 2
// Stan po wstępnym oczyszczeniu danych z przejazdu.
class CleanedDataState implements RideAnalysisState {
    @Override
    public void handle(Ride ride) {
        System.out.println("[State] Data cleaned for ride: " + ride.getRideId());
    }
}
// Koniec, Tydzień 6, Wzorzec State 2
