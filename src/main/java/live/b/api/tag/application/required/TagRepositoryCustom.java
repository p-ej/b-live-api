package live.b.api.tag.application.required;

import live.b.api.tag.application.dto.TagDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepositoryCustom {

    @Query("""
            SELECT new live.b.api.tag.application.dto.TagDto(t.id, t.type, t.code, tt.label)
            FROM Tag t
            JOIN t.translations tt
            WHERE tt.locale = :locale
            """)
    List<TagDto> findAllByLocale(String locale);
}
