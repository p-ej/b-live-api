package live.b.api.region.adapter.webapi;

import live.b.api.region.application.dto.RegionDto;
import live.b.api.region.application.provided.RegionFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/regions")
@RequiredArgsConstructor
public class RegionApi {

    private final RegionFinder regionFinder;

    @GetMapping
    public ResponseEntity<List<RegionDto>> regions(Locale locale) {
        return ResponseEntity.ok(regionFinder.findAll(locale));
    }
}
