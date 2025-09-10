package live.b.api.course.application.provided;

import live.b.api.course.domain.Course;
import live.b.api.course.domain.CourseRecommendRequest;

import java.util.List;

public interface CourseRecommender {

    List<Course> recommend(CourseRecommendRequest request);
}
