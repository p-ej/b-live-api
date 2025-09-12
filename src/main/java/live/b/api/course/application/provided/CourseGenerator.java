package live.b.api.course.application.provided;

import live.b.api.course.domain.Course;
import live.b.api.spot.domain.Spot;
import live.b.api.tag.domain.Tag;

import java.util.List;

public interface CourseGenerator {

    List<Course> generate(List<Spot> spots, List<Tag> tags);
}
