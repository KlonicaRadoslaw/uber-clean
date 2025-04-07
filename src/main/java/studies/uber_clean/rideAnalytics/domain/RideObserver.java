package studies.uber_clean.rideAnalytics.domain;

import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Observer 2
// Interfejs definiujący metodę aktualizacji obserwatorów na podstawie nowych danych
interface RideObserver {
    void update(Ride ride);
}
// Koniec, Tydzień 6, Wzorzec Observer 2