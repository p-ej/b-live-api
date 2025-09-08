package live.b.api.tag.adapter.persistence;

import live.b.api.tag.application.dto.TagDto;
import live.b.api.tag.application.required.TagRepositoryCustom;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepositoryCustom {

    private final JdbcClient jdbcClient;

    public TagRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<TagDto> findAllByLocale(String locale) {
        return jdbcClient.sql("""
                        SELECT 
                            t.tag_id tagId, 
                            t.type tagType,
                            t.code tagCode,
                            tt.name tagName
                        FROM tag t 
                            join tag_translation tt on t.tag_id = tt.tag_id 
                        WHERE locale = :locale
                        """)
                .param("locale", locale)
                .query(TagDto.class)
                .list();
    }
}
