package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Interpreter 2
public class CompositeDiscountExpression implements DiscountExpression {
    private final List<DiscountExpression> expressions = new ArrayList<>();

    public void addExpression(DiscountExpression expression) {
        expressions.add(expression);
    }

    @Override
    public BigDecimal interpret(BigDecimal price) {
        BigDecimal result = price;
        for (DiscountExpression expression : expressions) {
            result = expression.interpret(result);
        }
        return result;
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 2