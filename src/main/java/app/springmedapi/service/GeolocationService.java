package app.springmedapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.springmedapi.service.external.OpenCageClient;
import app.springmedapi.service.external.dto.GeolocationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class GeolocationService {
    private final OpenCageClient openCageClient;
    private final Logger logger = LoggerFactory.getLogger(GeolocationService.class);

    public GeolocationService(OpenCageClient openCageClient) {
        this.openCageClient = openCageClient;
    }
// TODO: Aguardar desenvolvimento das entidades de consulta e paciente

    public double[] fetchCoordinates(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        GeolocationResultDTO geolocationResultDTO = openCageClient.fetchCoordinates(address);
        if (geolocationResultDTO.confidence() < 5) {
            throw new RuntimeException("Could not find coordinates for the given address");
        }
        logger.info("Coordinates found for address: {}, latitude: {}, longitude: {}", address, geolocationResultDTO.lat(), geolocationResultDTO.lng());
        return new double[]{geolocationResultDTO.lat(), geolocationResultDTO.lng()};
    }
}