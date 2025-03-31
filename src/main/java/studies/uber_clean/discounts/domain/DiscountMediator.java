package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;

// Tydzien 5, Wzorzec Mediator 2
public interface DiscountMediator {
    void applyDiscountToUser(String userId, BigDecimal price);
}
// Koniec, Tydzien 5, Wzorzec Mediator 2