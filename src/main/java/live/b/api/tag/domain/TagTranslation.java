package live.b.api.tag.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Locale;

@Entity
public class TagTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_translation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "locale")
    private String locale;

    @Column(name = "name")
    private String name;

    protected TagTranslation() {}

    public TagTranslation(Tag tag, Locale locale, String name) {
        this.tag = tag;
        this.locale = locale.getLanguage();
        this.name = name;
    }
}
