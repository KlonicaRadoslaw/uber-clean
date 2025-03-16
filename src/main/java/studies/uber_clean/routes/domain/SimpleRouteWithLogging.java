package studies.uber_clean.routes.domain;
// Tydzień 2, Wzorzec Decorator 1
// Podstawowy Route do składania CompositeRoute
public class SimpleRouteWithLogging extends SimpleRoute {
    private final SimpleRoute decoratedSimpleRoute;

    public SimpleRouteWithLogging(SimpleRoute decoratedSimpleRoute) {
        this.decoratedSimpleRoute = decoratedSimpleRoute;
    }

    @Override
    public Long getId() {
        return decoratedSimpleRoute.getId();
    }

    @Override
    public void displayRoute() {
        // Logowanie przed wywołaniem oryginalnej metody
        System.out.println("Logging: Displaying simple route from " + decoratedSimpleRoute.getStartPoint() + " to " + decoratedSimpleRoute.getEndPoint());
        decoratedSimpleRoute.displayRoute(); // Wywołanie oryginalnej metody displayRoute
    }
}
// Koniec, Tydzień 2, Wzorzec Decorator 1