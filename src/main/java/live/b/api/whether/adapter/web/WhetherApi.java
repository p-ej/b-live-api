package live.b.api.whether.adapter.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/whether")
public class WhetherApi {

    @GetMapping
    public ResponseEntity<WhetherResponse> whether() {
        return ResponseEntity.ok(new WhetherResponse("23"));
    }
}
