package live.b.api.tag.application.required;

import live.b.api.tag.application.dto.TagDto;

import java.util.List;

public interface TagRepositoryCustom {

    List<TagDto> findAllByLocale(String locale);
}
