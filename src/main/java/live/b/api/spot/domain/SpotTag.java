package live.b.api.spot.domain;

import jakarta.persistence.*;
import live.b.api.tag.domain.Tag;

@Entity
public class SpotTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spot_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "spot_id")
    private Spot spot;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
