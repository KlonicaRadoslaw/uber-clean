package studies.uber_clean.discounts.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// Tydzien 5, Wzorzec Mediator 2
public class DiscountMediatorImpl implements DiscountMediator {
    private final DiscountBundle discountBundle;
    private final Map<String, BigDecimal> userBalances = new HashMap<>();

    public DiscountMediatorImpl(DiscountBundle discountBundle) {
        this.discountBundle = discountBundle;
    }

    @Override
    public void applyDiscountToUser(String userId, BigDecimal price) {
        BigDecimal discountedPrice = discountBundle.applyDiscount(price);
        userBalances.put(userId, discountedPrice);
        System.out.println("User " + userId + " has new balance: " + discountedPrice);
    }

    public BigDecimal getUserBalance(String userId) {
        return userBalances.getOrDefault(userId, BigDecimal.ZERO);
    }
}
// Koniec, Tydzien 5, Wzorzec Mediator 2