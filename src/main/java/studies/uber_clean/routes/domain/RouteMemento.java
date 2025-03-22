package studies.uber_clean.routes.domain;

//Tydzień 5, Wzorzec Memento 1
public class RouteMemento {
    private final int index;

    public RouteMemento(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
// Koniec, Tydzień 5, Wzorzec Memento 1