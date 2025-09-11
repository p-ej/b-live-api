package live.b.api.spot.adapter.webapi;

import live.b.api.spot.application.SpotDto;
import live.b.api.spot.application.provided.SpotFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spots")
@RequiredArgsConstructor
public class SpotApi {

    private final SpotFinder spotFinder;

    @GetMapping("/popular")
    public ResponseEntity<List<SpotDto>> popular(@RequestParam(required = false, defaultValue = "5") Integer limit) {
        return ResponseEntity.ok(spotFinder.findPopular(limit));
    }
}
