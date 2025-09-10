package live.b.api.course.adapter.web;

import java.util.List;

public record PopularCourseResponse(
        Long courseId,
        String courseName,
        String courseTitle,
        String courseDescription,
        Float durationHours,
        String courseImageUrl,
        List<SpotResponse> spots
) {
    public record SpotResponse(
            Long spotId,
            String spotName
    ) {
    }
}
