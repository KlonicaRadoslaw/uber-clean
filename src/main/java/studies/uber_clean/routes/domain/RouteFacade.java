package studies.uber_clean.routes.domain;

import java.util.Optional;

// Tydzień 4, Wzorzec Facade 1
public class RouteFacade {
    private final SimpleRouteRepository simpleRouteRepository;
    private final CompositeRouteRepository compositeRouteRepository;

    public RouteFacade(SimpleRouteRepository simpleRouteRepository, CompositeRouteRepository compositeRouteRepository) {
        this.simpleRouteRepository = simpleRouteRepository;
        this.compositeRouteRepository = compositeRouteRepository;
    }

    public SimpleRoute addSimpleRoute(String startPoint, String endPoint) {
        SimpleRoute simpleRoute = new SimpleRoute(startPoint, endPoint);

        return simpleRouteRepository.save(simpleRoute);
    }

    public CompositeRoute addCompositeRoute(Long simpleRouteId1, Long simpleRouteId2) {
        SimpleRoute simpleRoute1 = simpleRouteRepository.findById(simpleRouteId1)
                .orElseThrow(() -> new RuntimeException("Simple route not found with id: " + simpleRouteId1));
        SimpleRoute simpleRoute2 = simpleRouteRepository.findById(simpleRouteId2)
                .orElseThrow(() -> new RuntimeException("Simple route not found with id: " + simpleRouteId2));

        CompositeRoute compositeRoute = new CompositeRoute();
        compositeRoute.addRoute(simpleRoute1);
        compositeRoute.addRoute(simpleRoute2);

        return compositeRouteRepository.save(compositeRoute);
    }

    public void displayRoute(Route route) {
        // Opakowujemy w dekorator i wywołujemy metodę displayRoute
        Route decoratedRoute = new RouteWithLogging(route);
        decoratedRoute.displayRoute(); // Wywołanie metody displayRoute na dekorowanym obiekcie
    }

    public void displaySimpleRouteWithLogging(SimpleRoute simpleRoute) {
        SimpleRoute decoratedRoute = new SimpleRouteWithLogging(simpleRoute);
        decoratedRoute.displayRoute(); // Wywołanie metody displayRoute na dekorowanym obiekcie
    }

    public Optional<SimpleRoute> getSimpleRouteById(Long routeId) {
        return simpleRouteRepository.findById(routeId);
    }

    // Tydzień 5, Wzorzec Iterator 1
    public void displayAllRoutesInComposite(CompositeRoute compositeRoute) {
        RouteIterator iterator = compositeRoute.createIterator();
        while (iterator.hasNext()) {
            iterator.next().displayRoute();
        }
    }

    public Optional<CompositeRoute> getCompositeRouteById(Long id) {
        return compositeRouteRepository.findById(id);
    }
    // Koniec, Tydzień 5, Wzorzec Iterator 1
}
// Koniec, Tydzień 4, Wzorzec Facade 1