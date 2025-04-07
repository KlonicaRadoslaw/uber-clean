package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Strategy 2
// Interfejs strategii analizy danych przejazdu.
interface AnalysisStrategy {
    String analyze(Ride ride);
}
// Koniec, Tydzień 6, Wzorzec Strategy 2