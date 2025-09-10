package live.b.api.spot.application.required;

import live.b.api.spot.domain.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long>, SpotRepositoryCustom {
}
