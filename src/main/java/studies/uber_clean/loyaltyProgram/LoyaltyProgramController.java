package studies.uber_clean.loyaltyProgram;


import org.springframework.web.bind.annotation.*;
import studies.uber_clean.loyaltyProgram.domain.LoyaltyProgramFacade;
import studies.uber_clean.loyaltyProgram.domain.PointsStrategy;
import studies.uber_clean.loyaltyProgram.domain.StandardPointsStrategy;
import studies.uber_clean.users.domain.User;

@RestController
@RequestMapping("/loyalty")
public class LoyaltyProgramController {
    private final LoyaltyProgramFacade loyaltyFacade;

    public LoyaltyProgramController(LoyaltyProgramFacade loyaltyFacade) {
        this.loyaltyFacade = loyaltyFacade;
    }

    /**
     * Rejestracja użytkownika w programie lojalnościowym.
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        loyaltyFacade.registerUser(user);
        return "User registered in loyalty program.";
    }

    /**
     * Dodanie punktów użytkownikowi na podstawie wydanej kwoty.
     */
    @PostMapping("/add-points")
    public String addPoints(@RequestParam Long userId, @RequestParam double amountSpent) {
        loyaltyFacade.addPoints(userId, amountSpent);
        return "Points added successfully.";
    }

    /**
     * Pobranie raportu lojalnościowego użytkownika.
     */
    @GetMapping("/report")
    public String getLoyaltyReport(@RequestParam Long userId) {
        return loyaltyFacade.generateLoyaltyReport(userId);
    }

    /**
     * Zmiana strategii naliczania punktów (np. promocja, specjalne dni).
     */
    @PostMapping("/set-strategy")
    public String setPointsStrategy(@RequestParam String strategyType) {
        PointsStrategy strategy;
        if ("standard".equalsIgnoreCase(strategyType)) {
            strategy = new StandardPointsStrategy();
        } else {
            return "Invalid strategy type.";
        }
        loyaltyFacade.setPointsStrategy(strategy);
        return "Points strategy updated.";
    }

    @PostMapping("/users/{userId}/points")
    public void addPoints(@PathVariable Long userId, @RequestParam int points) {
        loyaltyFacade.addPoints(userId, points);
    }

    @PostMapping("/users/{userId}/rewards/discount")
    public void grantDiscountReward(@PathVariable Long userId) {
        loyaltyFacade.grantDiscountReward(userId);
    }

    @PostMapping("/users/{userId}/rewards/free-ride")
    public void grantFreeRideReward(@PathVariable Long userId) {
        loyaltyFacade.grantFreeRideReward(userId);
    }
}