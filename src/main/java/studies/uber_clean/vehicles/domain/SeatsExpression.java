package studies.uber_clean.vehicles.domain;

import java.util.List;
import java.util.stream.Collectors;

// Tydzień 5, Wzorzec Interpreter 1
/**
 * Filtruje samochody na podstawie liczby miejsc.
 */
public class SeatsExpression implements Expression {
    private final int minSeats;

    public SeatsExpression(int minSeats) {
        this.minSeats = minSeats;
    }

    @Override
    public List<Vehicle> interpret(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(v -> v instanceof Car && ((Car) v).getSeats() > minSeats)
                .collect(Collectors.toList());
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1