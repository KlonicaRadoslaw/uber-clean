package studies.uber_clean.users.domain;

import jakarta.persistence.*;
import studies.uber_clean.users.dto.responses.UserDetailedResponse;
import studies.uber_clean.users.dto.responses.UserSimplifiedResponse;

// Tydzień 1, Wzorzec Factory 1
// Na klasie User bazują klasy Customer oraz Driver

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long userId;

    protected String email;
    protected String password;
    protected String phoneNumber;

    public User() {}

    public User(String email, String password, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public static UserSimplifiedResponse toSimplifiedResponse(User user) {
        return new UserSimplifiedResponse(user.userId, user.email);
    }

    public static UserDetailedResponse toDetailedResponse(User user) {
        String userType = "";

        if (user instanceof Driver) {
            userType = "Driver";
        } else if (user instanceof Customer) {
            userType = "Customer";
        }

        return new UserDetailedResponse(user.userId, user.email, user.phoneNumber, userType);
    }

    public String getEmail() {
        return email;
    }

    public Long getUserId() {
        return userId;
    }
}
// Koniec, Tydzień 1, Wzorzec Factory 1