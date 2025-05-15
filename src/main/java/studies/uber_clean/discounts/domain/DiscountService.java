package studies.uber_clean.discounts.domain;

import org.springframework.stereotype.Service;

// Tydzień 11, AspectJ 1
@Service
public class DiscountService {
    public double applyDiscount(double rideCost) {
        return rideCost * 0.85; // 15% zniżki
    }
}
// Koniec, Tydzień 11, AspectJ 1