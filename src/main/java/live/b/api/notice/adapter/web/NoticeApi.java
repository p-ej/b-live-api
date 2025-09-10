package live.b.api.notice.adapter.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notices")
public class NoticeApi {

    @GetMapping
    public ResponseEntity<List<NoticeResponse>> notices() {
        return ResponseEntity.ok(List.of());
    }
}
