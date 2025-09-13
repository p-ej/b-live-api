package live.b.api.region.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Getter
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long id;

    private String imageUrl;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegionTranslation> translations = new ArrayList<>();

    public void addTranslation(Locale locale, String name) {
        RegionTranslation translation = new RegionTranslation(this, locale.getLanguage(), name);
        translations.add(translation);
    }
}
