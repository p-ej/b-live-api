package live.b.api.course.application.dto;

import live.b.api.course.domain.Course;
import live.b.api.spot.application.dto.SpotDto;
import live.b.api.spot.application.dto.DistanceDto;
import live.b.api.tag.application.dto.TagDto;

import java.util.List;

public record CourseDto(
        Long courseId,
        String name,

        List<SpotDto> spots,
        List<TagDto> tags,
        List<DistanceDto> distances
) {
    public Course toEntity() {
        return null;
    }
}
