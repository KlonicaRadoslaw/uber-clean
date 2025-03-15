package studies.uber_clean.routes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// Tydzień 2, Wzorzec Composite 1
// Podstawowy Route do składania CompositeRoute
public abstract class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public abstract void displayRoute();
}
// Koniec, Tydzień 2, Wzorzec Composite 1