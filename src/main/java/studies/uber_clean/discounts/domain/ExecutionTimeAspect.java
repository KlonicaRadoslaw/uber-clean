package studies.uber_clean.discounts.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// Tydzień 11, AspectJ 1
@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("execution(* studies.uber_clean.discounts.domain.DiscountService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long duration = System.nanoTime() - start;
        System.out.println(">> [ASPECT] Czas wykonania metody " + joinPoint.getSignature().getName() + ": " + duration / 1_000_000 + " ms");
        return result;
    }
}
// Koniec, Tydzień 11, AspectJ 1