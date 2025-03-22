package studies.uber_clean.routes.domain;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
// Tydzień 2, Wzorzec Composite 1
// CompositeRoute składa się z wielu Route
public class CompositeRoute extends Route {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "composite_route_id")
    private List<Route> routes = new ArrayList<>();

    public void addRoute(Route route) {
        routes.add(route);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void displayRoute() {
        System.out.println("Composite route consisting of:");
        routes.forEach(Route::displayRoute);
    }

    public List<Route> getRoutes() {
        return routes;
    }

    // Tydzień 5, Wzorzec Iterator 1
    public RouteIterator createIterator() {
        return new CompositeRouteIterator(routes);
    }
    // Koniec, Tydzień 5, Wzorzec Iterator 1
}
// Koniec, Tydzień 2, Wzorzec Composite 1