package live.b.api;

import live.b.api.tag.application.dto.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Map;

//@RestController
@RequiredArgsConstructor
public class HealthController {

    private final ChatClient chatClient;
    private final RestClient restClient;
    private final Resource spotGuide;


    @GetMapping("/")
    public String hello() {
        System.out.println("'/' ok");
        return "Call Ok";
    }

    @GetMapping("/json")
    public Map<String, String> jsonHello() {
        System.out.println("'/json' ok");
        return Map.of("message", "Call Ok");
    }

    @GetMapping(value = "/take", produces = {"application/json"})
    public ResponseEntity<List<Response>> take() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://apis.data.go.kr/B551011/KorService2/areaBasedList2")
                .queryParam("MobileOS", "WEB")
                .queryParam("MobileApp", "B.LIVE")
                .queryParam("_type", "json")
                .queryParam("areaCode", 6)
                .queryParam("ServiceKey", "sohLflNEnTS3UJQ7sp69xl/jR7hKGdvZbIAwDHdZZ5RLrE7fuoeXBmObDoza71HsvUbni9yDmd8aiqx8IcDzxw==")
                .encode()
                .build()
                .toUri();

        String body = restClient.get()
                .uri(uri)
                .retrieve()
                .body(String.class);

        if (body == null) {
            throw new IllegalStateException("body is null");
        }

        return ResponseEntity.ok(
                chatClient.prompt()
                        .system(spotGuide)
                        .user(body)
                        .call()
                        .entity(new ParameterizedTypeReference<>() {
                        }));
    }

    public record Response(
            String title,
            String description,
            BigDecimal lat,
            BigDecimal lng,
            String region,
            List<TagDto> tags,
            Integer visitDuration
    ) {
    }
}
