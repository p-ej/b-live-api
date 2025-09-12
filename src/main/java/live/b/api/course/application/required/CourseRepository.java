package live.b.api.course.application.required;

import live.b.api.course.domain.Course;
import live.b.api.region.domain.Region;
import live.b.api.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {

    List<Course> findAllByRegionAndTagIn(Region region, List<Tag> tags);
}
