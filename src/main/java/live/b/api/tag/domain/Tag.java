package live.b.api.tag.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    private String type;

    private String code;

    @OneToMany(mappedBy = "tag")
    private List<TagTranslation> translations = new ArrayList<>();

    protected Tag() {}

    public Tag(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public void addTranslation(Locale locale, String label) {
        TagTranslation translation = new TagTranslation(this, locale, label);
        this.translations.add(translation);
    }
}
