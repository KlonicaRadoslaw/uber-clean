package studies.uber_clean.rides.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideOrderRepository  extends JpaRepository<RideOrder, Long> {
}
