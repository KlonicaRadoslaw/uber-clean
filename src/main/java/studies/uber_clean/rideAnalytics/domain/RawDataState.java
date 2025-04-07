package studies.uber_clean.rideAnalytics.domain;


import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec State 2
// Stan reprezentujący surowe, nieprzetworzone dane
class RawDataState implements RideAnalysisState {
    @Override
    public void handle(Ride ride) {
        System.out.println("[State] Handling raw ride data: " + ride.getRideId());
    }
}
// Koniec, Tydzień 6, Wzorzec State 2