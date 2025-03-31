package studies.uber_clean.discounts.domain;

// Tydzień 5, Wzorzec Command 1
public interface DiscountCommand {
    void execute();
    void undo();
}
// Koniec, Tydzień 5, Wzorzec Command 1