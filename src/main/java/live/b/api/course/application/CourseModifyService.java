package live.b.api.course.application;

import live.b.api.course.application.dto.CourseDto;
import live.b.api.course.application.provided.CourseGenerator;
import live.b.api.course.application.provided.CourseRecommender;
import live.b.api.course.application.required.CourseRepository;
import live.b.api.course.domain.Course;
import live.b.api.course.domain.CourseRecommendRequest;
import live.b.api.region.application.provided.RegionFinder;
import live.b.api.region.domain.Region;
import live.b.api.spot.application.provided.SpotFinder;
import live.b.api.spot.domain.Spot;
import live.b.api.tag.application.provided.TagFinder;
import live.b.api.tag.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseModifyService implements CourseRecommender {

    private final CourseRepository courseRepository;
    private final CourseGenerator courseGenerator;
    private final SpotFinder spotFinder;
    private final RegionFinder regionFinder;
    private final TagFinder tagFinder;

    @Override
    public List<CourseDto> recommend(CourseRecommendRequest request) {
        Region region = regionFinder.find(request.regionId());
        List<Tag> tags = tagFinder.findAll(request.tagIds());
        if (tags.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // TODO: Region과 Tag로 Course 조회 로직 구현 필요
        List<Course> found = List.of();

        if (found.isEmpty()) {
            List<Spot> spots = spotFinder.find(region, 30);
            // 대충 ai 생성 Courses
            List<Course> generated = courseGenerator.generate(spots, tags);

        }


        return List.of();
    }
}
