package live.b.api.course.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    private String name;
    private String description;
    private Integer popularity;
    private Integer duration;

    @OneToMany(mappedBy = "course")
    @OrderBy("spotOrder ASC")
    private List<CourseSpot> spots = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<CourseTag> tags = new ArrayList<>();
}
