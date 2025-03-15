package studies.uber_clean.routes.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimpleRouteRepository extends JpaRepository<SimpleRoute, Long> {
    Optional<SimpleRoute> findById(Long id);
}
