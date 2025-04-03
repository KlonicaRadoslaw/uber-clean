package studies.uber_clean.loyaltyProgram.domain;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Observer 1
/**
 * Klasa zarządzająca powiadomieniami użytkowników w programie lojalnościowym.
 * Implementuje wzorzec **Observer**.
 */
public class LoyaltyNotifier {
    private final List<LoyaltyObserver> observers = new ArrayList<>();

    public void addObserver(LoyaltyObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.forEach(LoyaltyObserver::notifyObserver);
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 1