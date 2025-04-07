package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Strategy 2
//  Strategia analizująca czas przejazdu
class TimeAnalysisStrategy implements AnalysisStrategy {
    public String analyze(Ride ride) {
        return "Ride time: " + ride.getTripTimeInSeconds() + " seconds.";
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy 2