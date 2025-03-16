package studies.uber_clean.discounts;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.discounts.domain.DiscountBundle;
import studies.uber_clean.discounts.domain.SingleDiscount;

import java.math.BigDecimal;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
    private final DiscountBundle promoBundle = new DiscountBundle("Uber Promotions");

    @PostMapping("/add")
    public String addDiscount(@RequestParam String name, @RequestParam double amount, @RequestParam boolean isPercentage) {
        SingleDiscount discount = new SingleDiscount(name, BigDecimal.valueOf(amount), isPercentage);
        promoBundle.addDiscount(discount);
        return "Added discount: " + name;
    }

    @GetMapping("/apply")
    public String applyDiscount(@RequestParam double price) {
        BigDecimal finalPrice = promoBundle.applyDiscount(BigDecimal.valueOf(price));
        return "Final price after discounts: " + finalPrice + " PLN";
    }
}
