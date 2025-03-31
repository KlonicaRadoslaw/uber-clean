package studies.uber_clean.discounts.domain;

import java.util.Iterator;
import java.util.List;

// Tydzien 5, Wzorzec Iterator 2
public class DiscountBundleIterator implements DiscountIterator {
    private final Iterator<SingleDiscount> iterator;

    public DiscountBundleIterator(List<SingleDiscount> discounts) {
        this.iterator = discounts.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public DiscountComponent next() {
        return iterator.next();
    }
}
// Koniec, Tydzien 5, Wzorzec Iterator 2