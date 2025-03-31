package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;

// Tydzień 5, Wzorzec Interpreter 2
public interface DiscountExpression {
    BigDecimal interpret(BigDecimal price);
}
// Koniec, Tydzień 5, Wzorzec Interpreter 2