package live.b.api.course.application;

import live.b.api.course.application.provided.CourseRecommender;
import live.b.api.course.domain.Course;
import live.b.api.course.domain.CourseRecommendRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseModifyService implements CourseRecommender {

    @Override
    public List<Course> recommend(CourseRecommendRequest request) {
        // 코스 조회 있으면 return 없으면 생성
        return List.of();
    }
}
