package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 7, Wzorzec Single responsibility 1

import studies.uber_clean.users.domain.User;

import java.util.HashMap;
import java.util.Map;

public class LoyaltyProgramFacade {
    private final LoyaltyAccountManager accountManager = new LoyaltyAccountManager();
    private final RewardService rewardService = new RewardService();
    private final LoyaltyNotifier notifier = new LoyaltyNotifier();
    private PointsStrategy pointsStrategy = new StandardPointsStrategy();
    private final Map<String, LoyaltyRewardTemplate> rewardsRegistry = new HashMap<>();
    private final Map<Long, LoyaltyAccount> accounts = new HashMap<>();

    // Tydzień 7, Wzorzec Open closed data flow 1
    private void initializeRewards() {
        rewardsRegistry.put("discount", new DiscountReward());
        rewardsRegistry.put("freeRide", new FreeRideReward());
        // Możesz łatwo dodać nowe nagrody:
        // rewardsRegistry.put("vipRide", new VIPRideReward());
    }

    public void grantReward(Long userId, String rewardType) {
        LoyaltyAccount account = getLoyaltyAccount(userId);
        LoyaltyRewardTemplate reward = rewardsRegistry.get(rewardType.toLowerCase());
        if (reward != null) {
            reward.grantReward(account);
        } else {
            throw new IllegalArgumentException("Invalid reward type: " + rewardType);
        }
    }

    private LoyaltyAccount getLoyaltyAccount(Long userId) {
        if (!accounts.containsKey(userId)) {
            throw new IllegalArgumentException("User not registered in loyalty program.");
        }
        return accounts.get(userId);
    }
    // Koniec, Tydzień 7, Wzorzec Open closed data flow 1

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