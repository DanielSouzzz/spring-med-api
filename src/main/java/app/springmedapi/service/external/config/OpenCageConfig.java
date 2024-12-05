package app.springmedapi.service.external.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenCageConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}