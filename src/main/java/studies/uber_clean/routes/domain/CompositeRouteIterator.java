package studies.uber_clean.routes.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// Tydzień 5, Wzorzec Iterator 1
/**
 * Iterator do przeglądania tras w strukturze Composite.
 */
public class CompositeRouteIterator implements RouteIterator {
    private final Stack<Iterator<Route>> stack = new Stack<>();

    public CompositeRouteIterator(List<Route> routes) {
        stack.push(routes.iterator());
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<Route> iterator = stack.peek();
            if (iterator.hasNext()) {
                return true;
            } else {
                stack.pop();
            }
        }
        return false;
    }

    @Override
    public Route next() {
        if (hasNext()) {
            Iterator<Route> iterator = stack.peek();
            Route nextRoute = iterator.next();

            if (nextRoute instanceof CompositeRoute compositeRoute) {
                stack.push(compositeRoute.getRoutes().iterator());
            }

            return nextRoute;
        }
        return null;
    }
}
// Koniec, Tydzień 5, Wzorzec Iterator 1