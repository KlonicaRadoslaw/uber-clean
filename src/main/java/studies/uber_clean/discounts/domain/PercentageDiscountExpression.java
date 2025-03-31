package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;

// Tydzień 5, Wzorzec Interpreter 2
public class PercentageDiscountExpression implements DiscountExpression {
    private final BigDecimal percentage;

    public PercentageDiscountExpression(BigDecimal percentage) {
        this.percentage = percentage;
    }

    @Override
    public BigDecimal interpret(BigDecimal price) {
        return price.subtract(price.multiply(percentage.divide(BigDecimal.valueOf(100))));
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 2