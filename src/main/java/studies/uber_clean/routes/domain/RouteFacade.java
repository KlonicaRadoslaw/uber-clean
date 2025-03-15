package studies.uber_clean.routes.domain;

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

    public void displayRoute(RouteComponent route) {
        route.displayRoute();
    }
}
