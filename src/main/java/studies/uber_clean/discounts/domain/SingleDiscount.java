package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;

// Tydzień 2, Wzorzec Composite 2
// Podstawowy SingleDiscount do składania DiscountBundle
public class SingleDiscount implements DiscountComponent {
    private String name;
    private BigDecimal discountAmount;
    private boolean isPercentage;

    public SingleDiscount(String name, BigDecimal discountAmount, boolean isPercentage) {
        this.name = name;
        this.discountAmount = discountAmount;
        this.isPercentage = isPercentage;
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal price) {
        if (isPercentage) {
            return price.subtract(price.multiply(discountAmount.divide(BigDecimal.valueOf(100))));
        } else {
            return price.subtract(discountAmount).max(BigDecimal.ZERO);
        }
    }
}
// Koniec, Tydzień 2, Wzorzec Composite 2