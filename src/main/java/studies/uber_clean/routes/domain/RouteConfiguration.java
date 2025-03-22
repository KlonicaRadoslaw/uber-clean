package studies.uber_clean.routes.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RouteConfiguration {
    @Bean
    public RouteFacade routeFacade(SimpleRouteRepository simpleRouteRepository, CompositeRouteRepository compositeRouteRepository) {
        return new RouteFacade(simpleRouteRepository, compositeRouteRepository);
    }
    @Bean
    public RouteMediator routeMediator(RouteFacade routeFacade) {
        return new RouteMediator(routeFacade);
    }
}
