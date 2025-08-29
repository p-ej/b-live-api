package live.b.api.area.adapter.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/areas")
public class AreaApi {

    @GetMapping
    public ResponseEntity<List<AreaResponse>> areas() {
        return ResponseEntity.ok(List.of());
    }
}
