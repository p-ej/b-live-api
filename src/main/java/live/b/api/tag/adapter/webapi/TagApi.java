package live.b.api.tag.adapter.webapi;

import live.b.api.tag.application.dto.TagDto;
import live.b.api.tag.application.provided.TagFinder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/tags")
public class TagApi {

    private final TagFinder tagFinder;

    public TagApi(TagFinder tagFinder) {
        this.tagFinder = tagFinder;
    }

    @GetMapping
    public ResponseEntity<List<TagDto>> tags(
            Locale locale
    ) {
        return ResponseEntity.ok(tagFinder.findAll(locale));
    }
}
