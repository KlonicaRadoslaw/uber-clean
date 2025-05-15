package studies.uber_clean.discounts.domain;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Tydzień 11, AspectJ 1
@Aspect
@Component
public class DiscountLoggingAspect {

    @Before("execution(* studies.uber_clean.discounts.domain.DiscountService.applyDiscount(..))")
    public void logBefore() {
        System.out.println(">> [ASPECT] Zastosowano rabat");
    }
}
// Koniec, Tydzień 11, AspectJ 1