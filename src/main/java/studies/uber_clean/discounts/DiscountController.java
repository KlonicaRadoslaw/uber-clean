package studies.uber_clean.discounts;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.discounts.domain.AddDiscountCommand;
import studies.uber_clean.discounts.domain.DiscountBundle;
import studies.uber_clean.discounts.domain.DiscountInvoker;
import studies.uber_clean.discounts.domain.SingleDiscount;

import java.math.BigDecimal;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
    private final DiscountBundle promoBundle = new DiscountBundle("Uber Promotions");
    private final DiscountInvoker invoker = new DiscountInvoker();

    // Tydzień 5, Wzorzec Command 1
    @PostMapping("/add")
    public String addDiscount(@RequestParam String name, @RequestParam double amount, @RequestParam boolean isPercentage) {
        SingleDiscount discount = new SingleDiscount(name, BigDecimal.valueOf(amount), isPercentage);
        AddDiscountCommand command = new AddDiscountCommand(promoBundle, discount);
        invoker.executeCommand(command);
        return "Added discount: " + name;
    }

    @GetMapping("/apply")
    public String applyDiscount(@RequestParam double price) {
        BigDecimal finalPrice = promoBundle.applyDiscount(BigDecimal.valueOf(price));
        return "Final price after discounts: " + finalPrice + " PLN";
    }

    @PostMapping("/undo")
    public String undoLastDiscount() {
        invoker.undoLastCommand();
        return "Last discount undone!";
    }

    @PostMapping("/reset")
    public String resetAllDiscounts() {
        invoker.undoAllCommands();
        return "All discounts reset!";
    }
    // Koniec, Tydzień 5, Wzorzec Command 1
}