package om.litedesk.litedesk.api.service;

import om.litedesk.litedesk.api.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String MUSCAT_LAT = "23.588";
    private static final String MUSCAT_LON = "58.382";
    private static final String API_URL = "https://api.open-meteo.com/v1/forecast";

    public WeatherResponse getWeather(String latitude, String longitude) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "?latitude=" + latitude + "&longitude=" + longitude + "&current_weather=true";
        return restTemplate.getForObject(url, WeatherResponse.class);
    }

    public WeatherResponse getDefaultWeather() {
        return getWeather(MUSCAT_LAT, MUSCAT_LON);
    }
}