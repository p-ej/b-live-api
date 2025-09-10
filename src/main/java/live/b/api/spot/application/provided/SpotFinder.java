package live.b.api.spot.application.provided;

import live.b.api.spot.application.SpotDto;

import java.util.List;

public interface SpotFinder {

    List<SpotDto> findPopular(int limit);
}
