package live.b.api.spot.application.provided;

import live.b.api.region.domain.Region;
import live.b.api.spot.application.dto.SpotDto;
import live.b.api.spot.domain.Spot;

import java.util.List;

public interface SpotFinder {

    List<SpotDto> findPopular(int limit);

    List<Spot> find(Region region, int limit);
}
