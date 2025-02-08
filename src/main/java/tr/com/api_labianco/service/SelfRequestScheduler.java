package tr.com.api_labianco.service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SelfRequestScheduler {

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "0 0/15 9-22 * * ?")
    public void keepAliveRequest() {
        try {
            String SELF_URL = "http://localhost:8080/actuator/health";
            String response = restTemplate.getForObject(SELF_URL, String.class);
            System.out.println("Self-request successful: " + response);
        } catch (Exception e) {
            System.err.println("Error in self-request: " + e.getMessage());
        }
    }
}