package live.b.api.spot.adapter.webapi;

import live.b.api.spot.application.SpotDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spots")
public class SpotApi {

    @GetMapping("/popular")
    public ResponseEntity<List<SpotDto>> popular() {
        return ResponseEntity.ok(List.of(
                new SpotDto(1L, "여행지1", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg"),
                new SpotDto(2L, "여행지2", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg"),
                new SpotDto(3L, "여행지3", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg"),
                new SpotDto(4L, "여행지4", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg")
        ));
    }
}
