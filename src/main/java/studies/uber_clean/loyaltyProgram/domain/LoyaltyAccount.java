package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 6, Wzorzec Visitor 1
// Tydzień 6, Wzorzec State 1
// Tydzień 6, Wzorzec Template 1
// Tydzień 6, Wzorzec Observer 1

import studies.uber_clean.users.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca konto lojalnościowe użytkownika.
 * Implementuje wzorce: State (LoyaltyLevel), Template Method (addPoints), Visitor.
 */
public class LoyaltyAccount {
    private final User user;
    private int points = 0;
    private LoyaltyLevel level = new BronzeLevel(); // State: Domyślnie Bronze
    private final List<LoyaltyObserver> observers = new ArrayList<>();

    public LoyaltyAccount(User user) {
        this.user = user;
    }

    /**
     * Wzorzec **Template Method**: metoda do dodawania punktów.
     */
    public void addPoints(int points) {
        this.points += points;
        level.checkForUpgrade(this); // State Pattern: sprawdza awans
        notifyObserver();
    }

    /**
     * Wzorzec **State**: Przejście na wyższy poziom.
     */
    public void upgradeLevel() {
        level = level.nextLevel();
    }

    public int getPoints() {
        return points;
    }

    public String getLevelName() {
        return level.getLevelName();
    }

    public User getUser() {
        return user;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Implementacja **Visitor**: generowanie raportu.
     */
    public void accept(LoyaltyReportVisitor visitor) {
        visitor.visit(this);
    }

    public void notifyObserver() {
        System.out.println("User " + user.getEmail() + " now has " + points + " points.");
    }

    private void notifyObservers() {
        observers.forEach(LoyaltyObserver::notifyObserver);
    }
}
// Koniec, Tydzień 6, Wzorzec Visitor 1
// Koniec, Tydzień 6, Wzorzec State 1
// Koniec, Tydzień 6, Wzorzec Template 1
// Koniec, Tydzień 6, Wzorzec Observer 1