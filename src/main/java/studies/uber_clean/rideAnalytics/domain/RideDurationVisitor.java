package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Visitor 2
// Visitor dla czasu trwania przejazdu
public class RideDurationVisitor implements RideVisitor {
    @Override
    public String visit(Ride ride) {
        return "Ride duration was: " + ride.getTripTimeInSeconds() + " seconds.";
    }
}
// Koniec, Tydzień 6, Wzorzec Visitor 2