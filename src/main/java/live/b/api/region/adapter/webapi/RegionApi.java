package live.b.api.region.adapter.webapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/regions")
public class RegionApi {

    @GetMapping
    public ResponseEntity<List<RegionResponse>> regions() {
        return ResponseEntity.ok(List.of());
    }
}
