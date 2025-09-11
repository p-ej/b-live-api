package live.b.api.spot.domain;

import jakarta.persistence.*;
import live.b.api.region.domain.Region;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spot_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "popularity")
    private Integer popularity;

    @Column(name = "visit_duration")
    private Integer visitDuration;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "spot")
    private List<SpotTag> tags = new ArrayList<>();

}
