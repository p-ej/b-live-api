package live.b.api.spot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distance_id")
    private Long id;

    private Double distanceKm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_spot_id")
    private Spot fromSpot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_spot_id")
    private Spot toSpot;
}
