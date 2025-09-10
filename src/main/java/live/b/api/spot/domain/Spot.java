package live.b.api.spot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Spot {

    @Id
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private Integer popularity;

    private Integer visitDuration;
}
