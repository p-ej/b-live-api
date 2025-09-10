package live.b.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ResourceConfig {

    @Bean
    public Resource spotGuide() {
        return new ClassPathResource("/prompts/spot-guide.st");
    }
}
