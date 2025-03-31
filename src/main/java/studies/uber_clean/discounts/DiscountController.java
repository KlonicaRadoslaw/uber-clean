package studies.uber_clean.discounts;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.discounts.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
    private final DiscountBundle promoBundle = new DiscountBundle("Uber Promotions");
    private final DiscountInvoker invoker = new DiscountInvoker();
    private final DiscountMediatorImpl discountMediator = new DiscountMediatorImpl(promoBundle);

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

    // Tydzien 5, Wzorzec Mediator 2
    @PostMapping("/apply-to-user")
    public String applyDiscountToUser(@RequestParam String userId, @RequestParam double price) {
        discountMediator.applyDiscountToUser(userId, BigDecimal.valueOf(price));
        return "Discount applied for user: " + userId;
    }

    @GetMapping("/user-balance")
    public String getUserBalance(@RequestParam String userId) {
        return "User " + userId + " final price: " + discountMediator.getUserBalance(userId);
    }
    // Koniec, Tydzien 5, Wzorzec Mediator 2

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
    // Koniec, Tydzień 5, Wzorzec Command 2

    // Tydzień 5, Wzorzec Interpreter 2
    @PostMapping("/interpret")
    public String interpretDiscount(@RequestParam String rule, @RequestParam double price) {
        DiscountExpression expression = DiscountInterpreter.parse(rule);
        BigDecimal finalPrice = expression.interpret(BigDecimal.valueOf(price));
        return "Final price after interpreting rule '" + rule + "': " + finalPrice + " PLN";
    }
    // Koniec, Tydzień 5, Wzorzec Interpreter 2

    // Tydzien 5, Wzorzec Iterator 2
    @GetMapping("/list")
    public List<String> listDiscounts() {
        List<String> discountDescriptions = new ArrayList<>();
        DiscountIterator iterator = promoBundle.createIterator();

        while (iterator.hasNext()) {
            SingleDiscount discount = (SingleDiscount) iterator.next();
            String type = discount.isPercentage() ? "%" : "PLN";
            discountDescriptions.add(discount.getName() + ": " + discount.getDiscountAmount() + type);
        }
        return discountDescriptions;
    }
    // Koniec, Tydzien 5, Wzorzec Iterator 2
}