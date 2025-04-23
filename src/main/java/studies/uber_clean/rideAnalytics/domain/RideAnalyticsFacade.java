package studies.uber_clean.rideAnalytics.domain;

import org.springframework.stereotype.Service;
import studies.uber_clean.rides.domain.Ride;
import studies.uber_clean.rides.domain.RideRepository;

@Service
public class RideAnalyticsFacade {
    // Tydzień 6, Wzorzec Observer 2
    // Tydzień 6, Wzorzec State 2
    // Tydzień 6, Wzorzec Strategy 2
    // Tydzień 6, Wzorzec Template 2
    // Tydzień 6, Wzorzec Visitor 2
    // Tydzień 7, Wzorzec Single responsibility 2
    private final RideObserverRegistry observerRegistry = new RideObserverRegistry();
    private final RidePublisher ridePublisher = new RidePublisher(observerRegistry);
    private final RideAnalysisContext stateContext = new RideAnalysisContext();
    private final RideAnalysisStrategyRegistry rideAnalysisStrategyRegistry = new RideAnalysisStrategyRegistry();
    private final RideRepository rideRepository;

    public RideAnalyticsFacade(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
        observerRegistry.register(new AverageRideTimeObserver());
        observerRegistry.register(new PopularDestinationsObserver());

        // Tydzień 7, Wzorzec Open Closed 2
        rideAnalysisStrategyRegistry.register("time", new TimeAnalysisStrategy());
        rideAnalysisStrategyRegistry.register("cost", new CostAnalysisStrategy());
    }

    public void processNewRide(Ride ride) {
        ridePublisher.publish(ride);
        // Koniec, Tydzień 6, Wzorzec Observer
        // Koniec, Tydzień 7, Wzorzec Single responsibility 2

        stateContext.setState(new RawDataState());
        stateContext.handle(ride);
        stateContext.setState(new CleanedDataState());
        stateContext.handle(ride);
        // Koniec, Tydzień 6, Wzorzec State 2
    }

    public String runStrategy(String strategyName, Long rideId) {
        AnalysisStrategy strategy = rideAnalysisStrategyRegistry.getStrategy(strategyName.toLowerCase());
        if (strategy == null) {
            return "Unknown strategy";
        }

        RideAnalysisTemplate template = new ConcreteRideAnalysis(strategy);
        // Koniec, Tydzień 7, Wzorzec Open Closed 2
        Ride rideToAnalysis = rideRepository.findById(rideId).orElseThrow(() -> new IllegalArgumentException("Ride not found"));
        return template.executeAnalysis(rideToAnalysis);
        // Koniec, Tydzień 6, Wzorzec Strategy 2
        // Koniec, Tydzień 6, Wzorzec Template 2
    }

    public String visitRideData(String type, Long rideId) {
        Ride rideToVisit = rideRepository.findById(rideId).orElseThrow(() -> new IllegalArgumentException("Ride not found"));
        RideVisitor visitor;
        switch (type.toLowerCase()) {
            case "duration" -> visitor = new RideDurationVisitor();
            case "isPremium" -> visitor = new IsRidePremiumVisitor();
            case "cost" -> visitor = new RideCostVisitor();
            default -> {
                return "Unknown visit type";
            }
        }
        return rideToVisit.accept(visitor);
        // Koniec, Tydzień 6, Wzorzec Visitor 2
    }
}