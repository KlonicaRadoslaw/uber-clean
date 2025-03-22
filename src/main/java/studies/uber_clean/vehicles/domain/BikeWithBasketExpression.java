package studies.uber_clean.vehicles.domain;

import java.util.List;
import java.util.stream.Collectors;

// Tydzień 5, Wzorzec Interpreter 1
/**
 * Filtruje rowery posiadające koszyk.
 */
public class BikeWithBasketExpression implements Expression {
    @Override
    public List<Vehicle> interpret(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(v -> v instanceof Bike && ((Bike) v).doesHaveBasket())
                .collect(Collectors.toList());
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1