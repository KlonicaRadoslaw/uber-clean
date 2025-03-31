package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;

// Tydzień 5, Wzorzec Interpreter 2
public class DiscountInterpreter {
    public static DiscountExpression parse(String input) {
        String[] parts = input.split("\\s*\\+\\s*"); // Obsługa formatu "FIXED:10 + PERCENT:20"
        CompositeDiscountExpression compositeExpression = new CompositeDiscountExpression();

        for (String part : parts) {
            if (part.startsWith("FIXED:")) {
                BigDecimal amount = new BigDecimal(part.replace("FIXED:", ""));
                compositeExpression.addExpression(new FixedDiscountExpression(amount));
            } else if (part.startsWith("PERCENT:")) {
                BigDecimal percentage = new BigDecimal(part.replace("PERCENT:", ""));
                compositeExpression.addExpression(new PercentageDiscountExpression(percentage));
            }
        }
        return compositeExpression;
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter 2