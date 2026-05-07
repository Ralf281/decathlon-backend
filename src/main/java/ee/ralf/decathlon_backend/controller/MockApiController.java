package ee.ralf.decathlon_backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/mock")
public class MockApiController {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String JUDGES_URL =
            "https://69fce54a30ad0a6fd1c04711.mockapi.io/api/judges";

    private static final String LOCATIONS_URL =
            "https://69fce54a30ad0a6fd1c04711.mockapi.io/api/competitionLocations";

    @GetMapping("/judges")
    public String getJudges() {
        return restTemplate.getForObject(JUDGES_URL, String.class);
    }

    @GetMapping("/locations")
    public String getLocations() {
        return restTemplate.getForObject(LOCATIONS_URL, String.class);
    }
}
