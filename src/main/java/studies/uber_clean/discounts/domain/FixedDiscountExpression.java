package studies.uber_clean.discounts.domain;


import java.math.BigDecimal;

// Tydzień 5, Wzorzec Interpreter 2
public class FixedDiscountExpression implements DiscountExpression {
    private final BigDecimal discountAmount;

    public FixedDiscountExpression(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public BigDecimal interpret(BigDecimal price) {
        return price.subtract(discountAmount).max(BigDecimal.ZERO);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 2