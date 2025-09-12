package live.b.api.course.domain;

import java.util.List;

public record CourseRecommendRequest(
    Long regionId,
    List<Long> tagIds
) {
}
