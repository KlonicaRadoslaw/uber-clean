package studies.uber_clean.discounts.domain;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Tydzień 11, AspectJ 1
@Aspect
@Component
public class ValidationAspect {

    @Before("execution(* studies.uber_clean.discounts.domain.DiscountService.applyDiscount(..)) && args(rideCost)")
    public void validateDiscountValue(JoinPoint joinPoint, double rideCost) {
        if (rideCost < 0) {
            throw new IllegalArgumentException(">> [ASPECT] Cena nie może być ujemna!");
        }
        System.out.println(">> [ASPECT] Walidacja zakończona pomyślnie: " + rideCost);
    }
}
// Koniec, Tydzień 11, AspectJ 1