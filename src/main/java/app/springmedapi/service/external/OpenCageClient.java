package app.springmedapi.service.external;

import app.springmedapi.service.external.dto.GeolocationResultDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

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

        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        if (Objects.requireNonNull(response).hasNonNull("results")) {
            JsonNode firstResult = response.get("results").get(0);

            int confidence = firstResult.get("confidence").asInt();
            double lat = firstResult.get("geometry").get("lat").asDouble();
            double lng = firstResult.get("geometry").get("lng").asDouble();
            return new GeolocationResultDTO(lat, lng, confidence);

        }
         throw new RuntimeException();
    }
}