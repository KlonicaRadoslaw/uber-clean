package studies.uber_clean.rideAnalytics.domain;


import studies.uber_clean.rides.domain.Ride;

// Tydzień 6, Wzorzec Template 2
// Konkretna implementacja szablonu wykorzystująca wybraną strategię
class ConcreteRideAnalysis extends RideAnalysisTemplate {
    private final AnalysisStrategy strategy;

    public ConcreteRideAnalysis(AnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    protected void loadData(Ride ride) {
        System.out.println("[Template] Loaded ride data: " + ride.getRideId());
    }

    @Override
    protected String analyze(Ride ride) {
        return strategy.analyze(ride);
    }
}
// Koniec, Tydzień 6, Wzorzec Template 2