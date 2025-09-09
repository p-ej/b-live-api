package live.b.api.region.application;

import live.b.api.region.application.dto.RegionDto;
import live.b.api.region.application.provided.RegionFinder;
import live.b.api.region.application.required.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class RegionQueryService implements RegionFinder {

    private final RegionRepository regionRepository;


    @Override
    public List<RegionDto> findAll(Locale locale) {
        String language = locale.getLanguage();
        return regionRepository.findAllByLocale(language);
    }
}
