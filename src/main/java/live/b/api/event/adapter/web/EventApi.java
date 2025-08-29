package live.b.api.event.adapter.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventApi {

    @GetMapping
    public ResponseEntity<List<EventResponse>> events() {
        return ResponseEntity.ok(List.of(
                new EventResponse(1L, "쿠폰증정", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg", "골목 시장 쿠폰"),
                new EventResponse(1L, "할인혜택", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg", "50% 할인 쿠폰")
        ));
    }
}
