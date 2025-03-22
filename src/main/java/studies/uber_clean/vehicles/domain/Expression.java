package studies.uber_clean.vehicles.domain;

import java.util.List;

// Tydzień 5, Wzorzec Interpreter 1
/**
 * Interfejs Expression – definiuje metodę interpretującą zapytanie.
 */
public interface Expression {
    List<Vehicle> interpret(List<Vehicle> vehicles);
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1