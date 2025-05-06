package studies.uber_clean.discounts.domain;

// Tydzień 8, Wzorzec Interface segregation 2
// ISP - Gruby interfejs
public interface BulkDiscountService {
    void applyBulkDiscount();
    void cancelDiscount();
    void log();
    void notifyAdmin();
}
// Koniec, Tydzień 8, Wzorzec Interface segregation 2