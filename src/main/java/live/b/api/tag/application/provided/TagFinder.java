package live.b.api.tag.application.provided;

import live.b.api.tag.application.dto.TagDto;

import java.util.List;
import java.util.Locale;

public interface TagFinder {

    List<TagDto> findAll(Locale locale);
}
