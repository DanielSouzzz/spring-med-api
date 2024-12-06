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

    public double[] fetchCoordinates(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        GeolocationResultDTO geolocationResultDTO = openCageClient.fetchCoordinates(address);
        return new double[]{geolocationResultDTO.lat(), geolocationResultDTO.lng()};
    }
}