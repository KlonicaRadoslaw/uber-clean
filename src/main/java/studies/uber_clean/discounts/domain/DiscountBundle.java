package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Tydzień 2, Wzorzec Composite 2
// DiscountBundle składa się z wielu SingleDiscount
public class DiscountBundle implements DiscountComponent {
    private final String bundleName;
    private final List<SingleDiscount> discounts = new ArrayList<>();

    public DiscountBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void addDiscount(SingleDiscount discount) {
        discounts.add(discount);
    }

    public void removeDiscount(SingleDiscount discount) {
        discounts.remove(discount);
    }

    // Tydzien 5, Wzorzec Iterator 2
    public DiscountIterator createIterator() {
        return new DiscountBundleIterator(discounts);
    }
    // Koniec, Tydzien 5, Wzorzec Iterator 2

    @Override
    public BigDecimal applyDiscount(BigDecimal price) {
        BigDecimal finalPrice = price;
        for (DiscountComponent discount : discounts) {
            finalPrice = discount.applyDiscount(finalPrice);
        }
        return finalPrice;
    }

    public String getBundleName() {
        return bundleName;
    }
}
// Koniec, Tydzień 2, Wzorzec Composite 2