package studies.uber_clean.routes.domain;

import java.util.*;

// Tydzień 5, Wzorzec Mediator 1
/**
 * Mediator pośredniczący w operacjach na trasach.
 */
public class RouteMediator {
    private final RouteFacade routeFacade;
    private final Map<Long, RouteIteratorMemento> mementoStorage = new HashMap<>();

    public RouteMediator(RouteFacade routeFacade) {
        this.routeFacade = routeFacade;
    }

    /**
     * Pobiera listę tras z CompositeRoute przy użyciu iteratora.
     */
    public List<Route> getRoutesFromComposite(Long compositeRouteId) {
        Optional<CompositeRoute> compositeRouteOpt = routeFacade.getCompositeRouteById(compositeRouteId);

        if (compositeRouteOpt.isEmpty()) {
            throw new RuntimeException("CompositeRoute not found");
        }

        CompositeRoute compositeRoute = compositeRouteOpt.get();
        RouteIterator iterator = compositeRoute.createIterator();
        return iteratorToList(iterator);
    }

    //Tydzień 5, Wzorzec Memento 1
    public List<Route> getRoutesFromCompositeMemento(Long compositeRouteId) {
        CompositeRoute compositeRoute = routeFacade.getCompositeRouteById(compositeRouteId)
                .orElseThrow(() -> new RuntimeException("CompositeRoute not found"));

        RouteIterator iterator = compositeRoute.createIterator();

        // Przywracamy zapisany stan iteracji, jeśli istnieje
        if (mementoStorage.containsKey(compositeRouteId)) {
            RouteIteratorMemento memento = mementoStorage.get(compositeRouteId);
            for (int i = 0; i < memento.getIndex(); i++) {
                if (iterator.hasNext()) {
                    iterator.next(); // Przesuwamy iterator do zapisanej pozycji
                }
            }
        }

        List<Route> routes = iteratorToList(iterator);

        // Zapisujemy nowy stan iteracji po przejściu tras
        mementoStorage.put(compositeRouteId, new RouteIteratorMemento(routes.size()));

        return routes;
    }
    // Koniec, Tydzień 5, Wzorzec Memento 1

    private List<Route> iteratorToList(RouteIterator iterator) {
        List<Route> routesList = new ArrayList<>();
        while (iterator.hasNext()) {
            routesList.add(iterator.next());
        }
        return routesList;
    }

    //Tydzień 5, Wzorzec Memento 1
    public void resetIterator(Long compositeRouteId) {
        mementoStorage.remove(compositeRouteId);
    }
    // Koniec, Tydzień 5, Wzorzec Memento 1
}
// Koniec, Tydzień 5, Wzorzec Mediator 1