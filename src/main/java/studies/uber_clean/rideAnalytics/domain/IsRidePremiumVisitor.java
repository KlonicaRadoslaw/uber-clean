package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Visitor 2
// Visitor dla statusu premium przejazdu
public class IsRidePremiumVisitor implements RideVisitor {
    @Override
    public String visit(Ride ride) {
        return "Is ride premium? " + ride.isPremium();
    }
}
// Koniec, Tydzień 6, Wzorzec Visitor 2