package studies.uber_clean.loyaltyProgram.domain;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// Tydzień 11, AspectJ 2

@Aspect
@Component
public class PointsModificationAspect {

    @Before("execution(* studies.uber_clean.loyaltyProgram.domain.LoyaltyProgramFacade.addPoints(..))")
    public void beforePointsChange(JoinPoint joinPoint) {
        Object userId = joinPoint.getArgs()[0];
        System.out.println("📌 [Punkty] Modyfikacja punktów dla użytkownika ID: " + userId);
    }
}
// Koniec, Tydzień 11, AspectJ 2