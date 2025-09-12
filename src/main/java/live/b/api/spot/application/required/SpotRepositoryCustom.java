package live.b.api.spot.application.required;

import live.b.api.spot.application.dto.SpotDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpotRepositoryCustom {

    @Query("""
            SELECT new live.b.api.spot.application.dto.SpotDto(s.id, s.name, s.imageUrl)
            FROM Spot s
            ORDER BY s.popularity DESC
            LIMIT :limit
            """)
    List<SpotDto> findAllOrderByPopularityDesc(int limit);
}
