package studies.uber_clean.discounts.domain;

// Tydzień 5, Wzorzec Command 2
public class AddDiscountCommand implements DiscountCommand {
    private final DiscountBundle discountBundle;
    private final SingleDiscount discount;

    public AddDiscountCommand(DiscountBundle discountBundle, SingleDiscount discount) {
        this.discountBundle = discountBundle;
        this.discount = discount;
    }

    @Override
    public void execute() {
        discountBundle.addDiscount(discount);
    }

    @Override
    public void undo() {
        discountBundle.removeDiscount(discount);
    }
}
// Koniec, Tydzień 5, Wzorzec Command 2