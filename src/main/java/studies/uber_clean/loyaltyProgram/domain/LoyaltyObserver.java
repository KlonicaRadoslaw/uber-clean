package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Observer 1
/**
        * Observer - Interfejs dla obserwatorów programu lojalnościowego
 */
interface LoyaltyObserver {
    void update(String message);
    void notifyObserver();
}
// Koniec, Tydzień 6, Wzorzec Observer 1