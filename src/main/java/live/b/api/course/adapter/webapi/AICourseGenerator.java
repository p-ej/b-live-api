package live.b.api.course.adapter.webapi;

import live.b.api.course.application.dto.CourseDto;
import live.b.api.course.application.provided.CourseGenerator;
import live.b.api.course.domain.Course;
import live.b.api.spot.domain.Spot;
import live.b.api.tag.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AICourseGenerator implements CourseGenerator {

    private final Resource courseGenerateGuide;
    private final ChatClient chatClient;

    @Override
    public List<Course> generate(List<Spot> spots, List<Tag> tags) {

        List<CourseDto> generatedCourses = chatClient.prompt()
                .system(courseGenerateGuide)
                .user("")
                .call()
                .entity(new ParameterizedTypeReference<>() {
                });

        return generatedCourses.stream()
                .map(CourseDto::toEntity)
                .toList();
    }
}
