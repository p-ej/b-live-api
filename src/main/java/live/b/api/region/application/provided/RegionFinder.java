package live.b.api.region.application.provided;

import live.b.api.region.application.dto.RegionDto;
import live.b.api.region.domain.Region;

import java.util.List;
import java.util.Locale;

public interface RegionFinder {

    List<RegionDto> findAll(Locale locale);

    Region find(Long regionId);
}
