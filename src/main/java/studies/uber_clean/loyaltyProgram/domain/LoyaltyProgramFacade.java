package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 7, Wzorzec Single responsibility 1

import studies.uber_clean.users.domain.User;

public class LoyaltyProgramFacade {
    private final LoyaltyAccountManager accountManager = new LoyaltyAccountManager();
    private final RewardService rewardService = new RewardService();
    private final LoyaltyNotifier notifier = new LoyaltyNotifier();
    private PointsStrategy pointsStrategy = new StandardPointsStrategy();

    public void registerUser(User user) {
        accountManager.registerUser(user);
    }

    public void addPoints(Long userId, double amountSpent) {
        LoyaltyAccount account = accountManager.getAccount(userId);
        int points = pointsStrategy.calculatePoints(amountSpent);
        account.addPoints(points);
    }

    public void grantDiscountReward(Long userId) {
        LoyaltyAccount account = accountManager.getAccount(userId);
        rewardService.grantDiscountReward(account);
    }

    public void grantFreeRideReward(Long userId) {
        LoyaltyAccount account = accountManager.getAccount(userId);
        rewardService.grantFreeRideReward(account);
    }

    public String generateLoyaltyReport(Long userId) {
        LoyaltyAccount account = accountManager.getAccount(userId);
        LoyaltyReportVisitor visitor = new LoyaltyReportVisitor();
        account.accept(visitor);
        return visitor.getReport();
    }

    public void setPointsStrategy(PointsStrategy strategy) {
        this.pointsStrategy = strategy;
    }
}
// Koniec, Tydzień 7, Wzorzec Single responsibility 1