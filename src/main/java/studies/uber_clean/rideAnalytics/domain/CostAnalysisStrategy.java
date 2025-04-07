package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Strategy 2
// Strategia analizująca koszt przejazdu
class CostAnalysisStrategy implements AnalysisStrategy {
    public String analyze(Ride ride) {
        return "Ride cost: " + ride.getCost() + " PLN.";
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 2
