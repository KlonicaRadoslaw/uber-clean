package studies.uber_clean.routes.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositeRouteRepository extends JpaRepository<CompositeRoute, Long> {
}
