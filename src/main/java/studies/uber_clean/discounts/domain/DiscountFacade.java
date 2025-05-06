package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Dependency Invertion 10
// Fasada
public class DiscountFacade {
    private final DiscountCalculator calculator;
    private final DiscountPolicy policy;
    private final DiscountLogger logger;
    private final BaseDiscountApplier applier;
    private final DiscountNotifier notifier;
    private final BaseNotifierService notifierService;

    public DiscountFacade(
            DiscountCalculator calculator,
            DiscountPolicy policy,
            DiscountLogger logger,
            BaseDiscountApplier applier,
            DiscountNotifier notifier,
            BaseNotifierService notifierService
    ) {
        this.calculator = calculator;
        this.policy = policy;
        this.logger = logger;
        this.applier = applier;
        this.notifier = notifier;
        this.notifierService = notifierService;
    }

    public void processDiscount(String userId, double price) {
        if (policy.isApplicable(price)) {
            double discount = calculator.calculateDiscount(price);
            applier.applyDiscount(discount);
            logger.logDiscount("Discount " + discount + " applied for user " + userId);
            notifier.notifyUser(userId, discount);
            notifierService.sendNotification(userId, "You got a discount: " + discount);
        } else {
            logger.logDiscount("No discount applied for user " + userId);
        }
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 10