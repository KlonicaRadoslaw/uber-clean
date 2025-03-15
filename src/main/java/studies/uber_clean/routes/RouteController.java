package studies.uber_clean.routes;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.routes.domain.CompositeRoute;
import studies.uber_clean.routes.domain.RouteFacade;
import studies.uber_clean.routes.domain.SimpleRoute;

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
}
