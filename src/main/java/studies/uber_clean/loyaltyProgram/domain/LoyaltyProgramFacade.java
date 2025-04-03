package studies.uber_clean.loyaltyProgram.domain;

import studies.uber_clean.users.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Fasada obsługująca program lojalnościowy dla klientów i kierowców.
 */
public class LoyaltyProgramFacade {
    private final Map<Long, LoyaltyAccount> accounts = new HashMap<>();
    private final LoyaltyNotifier notifier = new LoyaltyNotifier();
    private PointsStrategy pointsStrategy = new StandardPointsStrategy(); // Domyślna strategia

    // Tydzień 6, Wzorzec Observer 1
    /**
     * Rejestracja nowego konta lojalnościowego.
     */
    public void registerUser(User user) {
        LoyaltyAccount account = new LoyaltyAccount(user);
        accounts.put(user.getUserId(), account);
        notifier.addObserver((LoyaltyObserver) account); // Observer: powiadamianie o zmianach
    }
    // Koniec, Tydzień 6, Wzorzec Observer 1

    // Tydzień 6, Wzorzec Strategy 1
    /**
     * Dodanie punktów użytkownikowi na podstawie wydanej kwoty.
     */
    public void addPoints(Long userId, double amountSpent) {
        LoyaltyAccount account = getLoyaltyAccount(userId);
        int points = pointsStrategy.calculatePoints(amountSpent); // Strategy: naliczanie punktów
        account.addPoints(points);
    }
    // Koniec, Tydzień 6, Wzorzec Strategy 1

    // Tydzień 6, Wzorzec Visitor 1
    /**
     * Generowanie raportu lojalnościowego użytkownika.
     */
    public String generateLoyaltyReport(Long userId) {
        LoyaltyAccount account = getLoyaltyAccount(userId);
        LoyaltyReportVisitor visitor = new LoyaltyReportVisitor(); // Visitor: raportowanie
        account.accept(visitor);
        return visitor.getReport();
    }
    // Koniec, Tydzień 6, Wzorzec Visitor 1

    public void addUserToLoyaltyProgram(User user) {
        LoyaltyAccount account = new LoyaltyAccount(user);
        accounts.put(user.getUserId(), account);
    }

    public void addPoints(Long userId, int points) {
        LoyaltyAccount account = accounts.get(userId);
        if (account != null) {
            account.addPoints(points);
        }
    }

    // Tydzień 6, Wzorzec Template 1
    public void grantDiscountReward(Long userId) {
        LoyaltyAccount account = accounts.get(userId);
        if (account != null) {
            new DiscountReward().grantReward(account);
        }
    }

    public void grantFreeRideReward(Long userId) {
        LoyaltyAccount account = accounts.get(userId);
        if (account != null) {
            new FreeRideReward().grantReward(account);
        }
    }
    // Koniec, Tydzień 6, Wzorzec Template 1
    /**
     * Zmiana strategii naliczania punktów.
     */
    public void setPointsStrategy(PointsStrategy strategy) {
        this.pointsStrategy = strategy;
    }

    private LoyaltyAccount getLoyaltyAccount(Long userId) {
        if (!accounts.containsKey(userId)) {
            throw new IllegalArgumentException("User not registered in loyalty program.");
        }
        return accounts.get(userId);
    }
}