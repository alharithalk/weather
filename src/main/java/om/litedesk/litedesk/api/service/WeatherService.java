package om.litedesk.litedesk.api.service;

import om.litedesk.litedesk.api.dto.GeocodingResponse;
import om.litedesk.litedesk.api.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String MUSCAT_LAT = "23.588";
    private static final String MUSCAT_LON = "58.382";
    private static final String MUSCAT_NAME = "Muscat";
    private static final String GEOCODING_URL = "https://geocoding-api.open-meteo.com/v1/search";
    private static final String WEATHER_URL = "https://api.open-meteo.com/v1/forecast";

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeather(String latitude, String longitude) {
        String url = WEATHER_URL + "?latitude=" + latitude + "&longitude=" + longitude + "&current_weather=true";
        return restTemplate.getForObject(url, WeatherResponse.class);
    }

    public WeatherResponse getDefaultWeather() {
        return getWeather(MUSCAT_LAT, MUSCAT_LON);
    }

    public String getDefaultCityName() {
        return MUSCAT_NAME + ", Oman";
    }

    public GeocodingResponse.GeocodingResult searchCity(String cityName) {
        String url = GEOCODING_URL + "?name=" + cityName.replace(" ", "+") + "&count=1&language=en&format=json";
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            return response.getResults().get(0);
        }
        return null;
    }

    public WeatherResponse getWeatherByCity(String cityName) {
        GeocodingResponse.GeocodingResult city = searchCity(cityName);
        if (city != null) {
            return getWeather(String.valueOf(city.getLatitude()), String.valueOf(city.getLongitude()));
        }
        return null;
    }
}