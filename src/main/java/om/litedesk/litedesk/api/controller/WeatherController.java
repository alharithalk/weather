package om.litedesk.litedesk.api.controller;

import om.litedesk.litedesk.api.dto.WeatherResponse;
import om.litedesk.litedesk.api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/weather")
@CrossOrigin(origins = "*")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public WeatherResponse getWeather(
            @RequestParam(required = false) String latitude,
            @RequestParam(required = false) String longitude) {
        if (latitude != null && longitude != null) {
            return weatherService.getWeather(latitude, longitude);
        }
        return weatherService.getDefaultWeather();
    }

    @GetMapping(path = "/default")
    public WeatherResponse getDefaultWeather() {
        return weatherService.getDefaultWeather();
    }
}