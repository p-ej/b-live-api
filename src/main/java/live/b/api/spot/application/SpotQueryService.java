package live.b.api.spot.application;

import live.b.api.spot.application.provided.SpotFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotQueryService implements SpotFinder {

    @Override
    public List<SpotDto> findPopular(int limit) {
        return List.of();
    }
}
