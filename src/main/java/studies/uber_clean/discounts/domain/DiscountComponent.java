package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;

public interface DiscountComponent {
    BigDecimal applyDiscount(BigDecimal price);
}