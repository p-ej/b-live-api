package live.b.api.spot.application;

import live.b.api.spot.application.dto.SpotDto;
import live.b.api.spot.application.provided.SpotFinder;
import live.b.api.spot.application.required.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotQueryService implements SpotFinder {

    private final SpotRepository spotRepository;

    @Override
    public List<SpotDto> findPopular(int limit) {
        return spotRepository.findAllOrderByPopularityDesc(limit);
    }
}
