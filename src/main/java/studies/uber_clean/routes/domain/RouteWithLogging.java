package studies.uber_clean.routes.domain;

public class RouteWithLogging extends Route{
    private final Route decoratedRoute;

    public RouteWithLogging(Route decoratedRoute) {
        this.decoratedRoute = decoratedRoute;
    }

    @Override
    public Long getId() {
        return decoratedRoute.getId();
    }

    @Override
    public void displayRoute() {
        // Logowanie przed wywołaniem oryginalnej metody
        System.out.println("Logging: Displaying route with ID " + decoratedRoute.getId());
        decoratedRoute.displayRoute(); // Wywołanie oryginalnej metody displayRoute
    }
}
