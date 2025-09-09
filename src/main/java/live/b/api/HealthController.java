package live.b.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class HealthController {

    private final ChatClient chatClient;
    private final RestClient restClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public HealthController(ChatModel chatModel, RestClient restClient) {
        this.chatClient = ChatClient.builder(chatModel)
                .defaultOptions(ChatOptions.builder()
                        .temperature(0.2)
                        .build())
                .build();
        this.restClient = restClient;
    }

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
    public ResponseEntity<String> take() throws JsonProcessingException {
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

        return ResponseEntity.ok(objectMapper.writeValueAsString(
                chatClient.prompt()
                        .system("""
                                당신은 여행지 가이드입니다.
                                아래 JSON 데이터를 기반으로
                                여행지에 대한 태그와 여행지를 소개하는 한 문장을 작성하세요.
                                중복된 표현 없이 간단하고 매력적으로 설명하세요.
                                
                                태그를 아래 세 분류 기준으로 분류하세요.
                                Environment: [산, 바다, 도시]
                                Theme: [힐링, 액티비티, 감성, 야경, 맛있는, 문화, 역사]
                                Activity: [식사, 카페, 관광, 산책, 쇼핑, 체험]
                                """)
                        .user(body)
                        .call()
                        .entity(new ParameterizedTypeReference<List<Response>>() {
                        })));
    }

    public record Response(
            String title,
            String description,
            BigDecimal lat,
            BigDecimal lng,
            String region,
            List<String> tags,
            Integer visitDuration
    ) {
    }
}
