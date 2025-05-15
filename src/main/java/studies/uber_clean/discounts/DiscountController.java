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
    private final DiscountFacade discountFacade;
    private final DiscountService discountService;
    public DiscountController(DiscountService discountService) {
        // Dependency Inversion – podajemy implementacje jako abstrakcje
        this.discountFacade = new DiscountFacade(
                new PercentageDiscountCalculator(),
                new MinimumPurchasePolicy(),
                new ConsoleDiscountLogger(),
                new SimpleDiscountApplier(),
                new EmailDiscountNotifier(),
                new SlackNotifierService()
        );

        this.discountService = discountService;
    }

    // Tydzień 5, Wzorzec Command 2
    @PostMapping("/add")
    public String addDiscount(@RequestParam String name, @RequestParam double amount, @RequestParam boolean isPercentage) {
        SingleDiscount discount = new SingleDiscount(name, BigDecimal.valueOf(amount), isPercentage);
        AddDiscountCommand command = new AddDiscountCommand(promoBundle, discount);
        invoker.executeCommand(command, promoBundle);
        return "Added discount: " + name;
    }

    @GetMapping("/apply")
    public String applyDiscount(@RequestParam double price) {
        BigDecimal finalPrice = promoBundle.applyDiscount(BigDecimal.valueOf(price));
        return "Final price after discounts: " + finalPrice + " PLN";
    }


    // Tydzień 5, Wzorzec Mediator 2
    @PostMapping("/apply-to-user")
    public String applyDiscountToUser(@RequestParam String userId, @RequestParam double price) {
        discountMediator.applyDiscountToUser(userId, BigDecimal.valueOf(price));
        return "Discount applied for user: " + userId;
    }

    @GetMapping("/user-balance")
    public String getUserBalance(@RequestParam String userId) {
        return "User " + userId + " final price: " + discountMediator.getUserBalance(userId);
    }
    // Koniec, Tydzień 5, Wzorzec Mediator 2


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


    // Tydzień 5, Wzorzec Iterator 2
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
    // Koniec, Tydzień 5, Wzorzec Iterator 2


    // Tydzień 5, Wzorzec Memento 2
    @PostMapping("/save-state")
    public String saveDiscountState() {
        DiscountBundleMemento memento = promoBundle.saveState();
        invoker.saveMemento(memento);
        return "Current discount state saved!";
    }

    @PostMapping("/undo-state")
    public String undoDiscountState() {
        invoker.undoLastState(promoBundle);
        return "Last discount state undone!";
    }
    // Koniec, Tydzień 5, Wzorzec Memento 2

    // Tydzień 8, Wzorzec Dependency Invertion 10
    @PostMapping("/process-discount")
    public void processDiscount(String userId, double price) {
        discountFacade.processDiscount(userId, price);
    }
    // Koniec, Tydzień 8, Wzorzec Dependency Invertion 10

    // Tydzień 8, Wzorzec Interface segregation 7
    @PostMapping("/test-ISP")
    public void testISP() {
        DiscountApplier applier = () -> System.out.println("Bulk discount applied!");
        DiscountLoggerSeparate logger = () -> System.out.println("Logged discount");
        DiscountNotifierSeparate notifier = () -> System.out.println("Admin notified");

        applier.applyBulkDiscount();
        logger.log();
        notifier.notifyAdmin();
    }
    // Koniec, Tydzień 8, Wzorzec Interface segregation 7

    // Tydzień 11, AspectJ 1
    @GetMapping("/applyForAspect")
    public double applyForAspect(@RequestParam double rideCost) {
        return discountService.applyDiscount(rideCost);
    }
    // Koniec, Tydzień 11, AspectJ 1
}