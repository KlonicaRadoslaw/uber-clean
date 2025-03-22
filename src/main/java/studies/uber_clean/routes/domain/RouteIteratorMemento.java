package studies.uber_clean.routes.domain;

import java.util.List;

//Tydzień 5, Wzorzec Memento 1
/**
 * Iterator dla CompositeRoute z obsługą Memento.
 */
public class RouteIteratorMemento {
    private final int index;

    public RouteIteratorMemento(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
// Koniec, Tydzień 5, Wzorzec Memento 1