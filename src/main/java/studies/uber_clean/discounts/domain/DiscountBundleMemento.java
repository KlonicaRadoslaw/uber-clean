package studies.uber_clean.discounts.domain;

import java.util.List;

// Tydzień 5, Wzorzec Memento 2
public class DiscountBundleMemento {
    private final List<SingleDiscount> discounts;

    public DiscountBundleMemento(List<SingleDiscount> discounts) {
        this.discounts = discounts;
    }

    public List<SingleDiscount> getDiscounts() {
        return discounts;
    }
}
// Koniec, Tydzień 5, Wzorzec Memento 2

