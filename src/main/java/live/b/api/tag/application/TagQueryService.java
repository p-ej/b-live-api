package live.b.api.tag.application;

import live.b.api.tag.application.dto.TagDto;
import live.b.api.tag.application.provided.TagFinder;
import live.b.api.tag.application.required.TagRepository;
import live.b.api.tag.domain.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class TagQueryService implements TagFinder {

    private final TagRepository tagRepository;

    public TagQueryService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagDto> findAll(Locale locale) {
        return tagRepository.findAllByLocale(locale.getLanguage());
    }

    @Override
    public List<Tag> findAll(List<Long> tagIds) {
        return tagRepository.findAllById(tagIds);
    }
}
