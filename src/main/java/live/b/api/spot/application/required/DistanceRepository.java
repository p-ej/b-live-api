package live.b.api.spot.application.required;

import live.b.api.spot.domain.Distance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistanceRepository extends JpaRepository<Distance, Long> {
}
