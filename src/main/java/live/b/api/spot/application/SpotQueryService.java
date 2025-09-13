package live.b.api.spot.application;

import live.b.api.region.domain.Region;
import live.b.api.spot.application.dto.SpotDto;
import live.b.api.spot.application.provided.SpotFinder;
import live.b.api.spot.application.required.SpotRepository;
import live.b.api.spot.domain.Spot;
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

    @Override
    public List<Spot> find(Region region, int limit) {
        // TODO: Region별 Spot 조회 로직 구현 필요
        return List.of();
    }
}
