package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Visitor 2
// Visitor dla ceny przejazdu
public class RideCostVisitor implements RideVisitor {
    @Override
    public String visit(Ride ride) {
        return "The ride cost : " + ride.getCost() + " PLN.";
    }
}
// Koniec, Tydzień 6, Wzorzec Visitor 2