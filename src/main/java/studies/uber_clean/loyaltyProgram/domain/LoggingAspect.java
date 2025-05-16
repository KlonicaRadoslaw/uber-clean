package studies.uber_clean.loyaltyProgram.domain;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// Tydzień 11, AspectJ 2

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* studies.uber_clean.loyaltyProgram.domain.LoyaltyProgramFacade.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        System.out.println("➡️ [LOG] Wejście do metody: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* studies.uber_clean.loyaltyProgram.domain.LoyaltyProgramFacade.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        System.out.println("⬅️ [LOG] Wyjście z metody: " + joinPoint.getSignature().getName());
    }
}

// Koniec, Tydzień 11, AspectJ 2