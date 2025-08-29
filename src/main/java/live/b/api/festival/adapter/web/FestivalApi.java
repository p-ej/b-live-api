package live.b.api.festival.adapter.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/festivals")
public class FestivalApi {

    @GetMapping
    public ResponseEntity<List<FestivalResponse>> festivals() {
        return ResponseEntity.ok(List.of(
                new FestivalResponse(1L, "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg"),
                new FestivalResponse(2L, "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg")
        ));
    }
}
