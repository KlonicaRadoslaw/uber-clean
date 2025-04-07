package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Visitor 2
// Interfejs definiujący metodę visit
public interface RideVisitor {
    String visit(Ride ride);
}
// Koniec, Tydzień 6, Wzorzec Visitor 2