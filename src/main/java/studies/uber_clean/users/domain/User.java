package studies.uber_clean.users.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    protected String email;
    protected String password;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
