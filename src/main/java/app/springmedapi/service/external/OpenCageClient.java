package app.springmedapi.service.external;

import app.springmedapi.service.external.dto.GeolocationResultDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenCageClient {
    private final RestTemplate restTemplate;
    private final String apiKey;

    public OpenCageClient(RestTemplate restTemplate, @Value("${opencage.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public GeolocationResultDTO fetchCoordinates(String address) {
        String url = String.format("https://api.opencagedata.com/geocode/v1/json?q=%s&key=%s", address, apiKey);
        return restTemplate.getForObject(url, GeolocationResultDTO.class);
    }
}