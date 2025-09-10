package live.b.api.region.application.required;

import live.b.api.region.application.dto.RegionDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepositoryCustom {

    @Query("""
            SELECT new live.b.api.region.application.dto.RegionDto(r.id, t.name, r.imageUrl)
            FROM Region r
            JOIN r.translations t
            WHERE t.locale = :locale
            """)
    List<RegionDto> findAllByLocale(String locale);
}
