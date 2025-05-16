package studies.uber_clean.loyaltyProgram.domain;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import studies.uber_clean.users.domain.User;

// Tydzień 11, AspectJ 2

@Aspect
@Component
public class ValidationAspect {

    @Before("execution(* studies.uber_clean.loyaltyProgram.domain.LoyaltyProgramFacade.registerUser(..)) && args(user)")
    public void validateUser(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("❌ Email użytkownika nie może być pusty");
        }
    }
}
// Koniec, Tydzień 11, AspectJ 2