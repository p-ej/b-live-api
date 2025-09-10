package live.b.api.region.application.required;

import live.b.api.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long>, RegionRepositoryCustom {

}
