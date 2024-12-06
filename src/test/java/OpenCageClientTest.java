import app.springmedapi.service.GeolocationService;
import app.springmedapi.service.external.OpenCageClient;
import org.springframework.web.client.RestTemplate;

public class OpenCageClientTest {
    public static void main(String[] args) {
        String apiKey = "ac85bffe841a4a6f8b6619bdc3e0ba2e";
        RestTemplate restTemplate = new RestTemplate();
        OpenCageClient openCageClient = new OpenCageClient(restTemplate, apiKey);

        String address = "Rua+Joao+Gualberto+de+Oliveira,+17,+Sao+Jose,+SC,+Brasil";

        GeolocationService geolocationService = new GeolocationService(openCageClient);
        double[] result = geolocationService.fetchCoordinates(address);
        System.out.println(result);
    }
}
