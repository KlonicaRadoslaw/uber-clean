package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec State 2
// Kontekst zarządzający aktualnym stanem przetwarzania danych.
class RideAnalysisContext {
    private RideAnalysisState state;

    public void setState(RideAnalysisState state) {
        this.state = state;
    }

    public void handle(Ride ride) {
        if (state != null) state.handle(ride);
    }
}
// Koniec, Tydzień 6, Wzorzec State 2