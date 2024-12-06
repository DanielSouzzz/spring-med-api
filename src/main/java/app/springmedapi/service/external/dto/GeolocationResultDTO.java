package app.springmedapi.service.external.dto;

public record GeolocationResultDTO(
        double lat,
        double lng,
        int confidence
) {}
