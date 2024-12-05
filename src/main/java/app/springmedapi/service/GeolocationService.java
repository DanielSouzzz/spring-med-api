package app.springmedapi.service;

import app.springmedapi.service.external.OpenCageClient;
import app.springmedapi.service.external.dto.GeolocationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class GeolocationService {
    private final OpenCageClient openCageClient;

    public GeolocationService(OpenCageClient openCageClient) {
        this.openCageClient = openCageClient;
    }

    public GeolocationResultDTO fetchCoordinates(String address) {
        return openCageClient.fetchCoordinates(address);
    }
}
