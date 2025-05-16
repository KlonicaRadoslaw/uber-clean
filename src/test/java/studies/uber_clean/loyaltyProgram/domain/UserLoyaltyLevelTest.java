package studies.uber_clean.loyaltyProgram.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import studies.uber_clean.users.domain.Customer;
import studies.uber_clean.users.domain.User;
import studies.uber_clean.users.domain.CustomerType;
import static org.junit.jupiter.api.Assertions.*;

// Tydzień 13, Unit tests 2
public class UserLoyaltyLevelTest {

    private User createTestUser() {
        return new Customer("test@example.com", "password123", "123456789", CustomerType.STANDARD);
    }

    @Test
    void shouldStartAtBronzeLevel() {
        LoyaltyAccount account = new LoyaltyAccount(createTestUser());
        assertEquals("Bronze", account.getLevelName());
    }

    @Test
    void shouldUpgradeFromBronzeToSilverWhenPointsAreEnough() {
        LoyaltyAccount account = new LoyaltyAccount(createTestUser());
        account.setPoints(500);
        account.addPoints(0); // trigger upgrade
        assertEquals("Silver", account.getLevelName());
    }

    @Test
    void shouldNotUpgradeFromBronzeIfPointsTooLow() {
        LoyaltyAccount account = new LoyaltyAccount(createTestUser());
        account.setPoints(499);
        account.addPoints(0); // trigger check
        assertEquals("Bronze", account.getLevelName());
    }

    @Test
    void shouldUpgradeFromSilverToGoldIfRuleAllows() {
        LoyaltyAccount account = new LoyaltyAccount(createTestUser());
        account.setPoints(1000);
        account.upgradeLevel(); // From Bronze to Silver
        account.addPoints(0);   // Should upgrade to Gold if rule allows
        assertEquals("Gold", account.getLevelName());
    }

    @Test
    void shouldNotUpgradeBeyondGold() {
        LoyaltyAccount account = new LoyaltyAccount(createTestUser());
        account.setPoints(2000);
        account.upgradeLevel(); // Bronze -> Silver
        account.upgradeLevel(); // Silver -> Gold
        account.addPoints(0);   // Should stay at Gold
        assertEquals("Gold", account.getLevelName());
    }
}
// Koniec, Tydzień 13, Unit tests 2