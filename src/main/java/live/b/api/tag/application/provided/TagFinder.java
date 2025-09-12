package live.b.api.tag.application.provided;

import live.b.api.tag.application.dto.TagDto;
import live.b.api.tag.domain.Tag;

import java.util.List;
import java.util.Locale;

public interface TagFinder {

    List<TagDto> findAll(Locale locale);

    List<Tag> findAll(List<Long> tagIds);
}
