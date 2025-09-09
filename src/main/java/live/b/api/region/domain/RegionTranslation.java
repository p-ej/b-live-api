package live.b.api.region.domain;

import jakarta.persistence.*;

@Entity
public class RegionTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_translation_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    private String locale;

    private String name;

    protected RegionTranslation() {}

    public RegionTranslation(Region region, String locale, String name) {
        this.region = region;
        this.locale = locale;
        this.name = name;
    }
}
