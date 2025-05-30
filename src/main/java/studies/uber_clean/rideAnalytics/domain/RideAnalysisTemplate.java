package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Template 2
// Abstrakcyjna klasa definiująca szkielet procesu analizy przejazdu
// Tydzień 7, Wzorzec Open Closed 2
abstract class RideAnalysisTemplate {
    public String executeAnalysis(Ride ride) {
        loadData(ride);
        return analyze(ride);
    }

    protected abstract void loadData(Ride ride);
    protected abstract String analyze(Ride ride);
}
// Tydzień 6, Wzorzec Template 2
// Koniec, Tydzień 7, Wzorzec Open Closed 2