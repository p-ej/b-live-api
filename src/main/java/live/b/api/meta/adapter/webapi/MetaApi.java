package live.b.api.meta.adapter.webapi;

import live.b.api.region.application.dto.RegionDto;
import live.b.api.region.application.provided.RegionFinder;
import live.b.api.tag.application.dto.TagDto;
import live.b.api.tag.application.provided.TagFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


@RestController
@RequestMapping("/api/v1/meta")
@RequiredArgsConstructor
public class MetaApi {

    private final RegionFinder regionFinder;
    private final TagFinder tagFinder;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getMeta(Locale locale) {
        List<RegionDto> regions = regionFinder.findAll(locale);
        List<TagDto> tags = tagFinder.findAll(locale);

        return ResponseEntity.ok(Map.of(
                "regions", regions,
                "tags", tags.stream()
                        .collect(groupingBy(TagDto::tagType))
        ));
    }

}

