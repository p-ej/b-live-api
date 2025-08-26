package live.b.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {
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

}
