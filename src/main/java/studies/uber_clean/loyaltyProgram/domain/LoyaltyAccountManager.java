package studies.uber_clean.loyaltyProgram.domain;
// Tydzień 7, Wzorzec Single responsibility 1

import studies.uber_clean.users.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Zarządza kontami lojalnościowymi użytkowników.
 */
public class LoyaltyAccountManager {
    private final Map<Long, LoyaltyAccount> accounts = new HashMap<>();

    public void registerUser(User user) {
        LoyaltyAccount account = new LoyaltyAccount(user);
        accounts.put(user.getUserId(), account);
    }

    public LoyaltyAccount getAccount(Long userId) {
        LoyaltyAccount account = accounts.get(userId);
        if (account == null) {
            throw new IllegalArgumentException("User not registered in loyalty program.");
        }
        return account;
    }
}
// Koniec, Tydzień 7, Wzorzec Single responsibility 1