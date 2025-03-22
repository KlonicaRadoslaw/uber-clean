package studies.uber_clean.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studies.uber_clean.routes.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/routes")
public class RouteController {
    private final RouteFacade routeFacade;

    public RouteController(RouteFacade routeFacade) {
        this.routeFacade = routeFacade;
    }

    @PostMapping("/simple")
    public SimpleRoute addSimpleRoute(@RequestParam String start, @RequestParam String end) {
        return routeFacade.addSimpleRoute(start, end);
    }

    @PostMapping("/composite")
    public CompositeRoute addCompositeRoute(@RequestParam Long simpleRouteId1, @RequestParam Long simpleRouteId2) {
        return routeFacade.addCompositeRoute(simpleRouteId1, simpleRouteId2);
    }
    @GetMapping("/displaySimpleRouteWithLogging/{routeId}")
    public void displaySimpleRouteWithLogging(@PathVariable Long routeId) {
        Optional<SimpleRoute> route = routeFacade.getSimpleRouteById(routeId); // Pobranie trasy
        routeFacade.displaySimpleRouteWithLogging(route.orElse(null)); // Wywołanie dekoratora z logowaniem
    }

    /**
     * Pobiera wszystkie trasy zawarte w CompositeRoute przy użyciu iteratora.
     * @param compositeRouteId ID compositeRoute do iterowania.
     * @return Lista tras w CompositeRoute.
     */
    @GetMapping("/{compositeRouteId}/iterate")
    public ResponseEntity<List<String>> iterateCompositeRoute(@PathVariable Long compositeRouteId) {
        CompositeRoute compositeRoute = routeFacade.getCompositeRouteById(compositeRouteId)
                .orElseThrow(() -> new RuntimeException("CompositeRoute not found"));

        RouteIterator iterator = compositeRoute.createIterator();
        List<String> routesList = new ArrayList<>();

        while (iterator.hasNext()) {
            Route route = iterator.next();
            routesList.add("Route ID: " + route.getId());
        }

        return ResponseEntity.ok(routesList);
    }
}
