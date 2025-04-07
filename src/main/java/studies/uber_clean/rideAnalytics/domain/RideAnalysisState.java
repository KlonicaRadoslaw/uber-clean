package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec State 2
// Interfejs stanu analizowania danych przejazdu.
interface RideAnalysisState {
    void handle(Ride ride);
}
// Tydzień 6, Wzorzec State 2