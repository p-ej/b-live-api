package live.b.api.theme.adapter.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/themes")
public class ThemeApi {

    @GetMapping
    public ResponseEntity<List<ThemeResponse>> themes() {
        return ResponseEntity.ok(
                List.of(
                        new ThemeResponse("테마1", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg", "광안대교"),
                        new ThemeResponse("테마2", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg", "광안대교")
                ));
    }
}
