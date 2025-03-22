package studies.uber_clean.vehicles.domain;

// Tydzień 5, Wzorzec Interpreter 1
/**
 * Interpreter zapytań – zamienia zapytanie tekstowe na obiekt Expression.
 */
public class QueryInterpreter {
    public static Expression parse(String query) {
        if (query.startsWith("car seats > ")) {
            int minSeats = Integer.parseInt(query.replace("car seats > ", ""));
            return new SeatsExpression(minSeats);
        } else if (query.equals("bike hasBasket = true")) {
            return new BikeWithBasketExpression();
        } else {
            throw new IllegalArgumentException("Nieznane zapytanie: " + query);
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 1