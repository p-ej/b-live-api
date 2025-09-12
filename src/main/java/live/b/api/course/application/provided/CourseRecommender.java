package live.b.api.course.application.provided;

import live.b.api.course.application.dto.CourseDto;
import live.b.api.course.domain.CourseRecommendRequest;

import java.util.List;

public interface CourseRecommender {

    List<CourseDto> recommend(CourseRecommendRequest request);
}
