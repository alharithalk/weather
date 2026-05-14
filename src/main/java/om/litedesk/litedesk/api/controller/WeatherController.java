package om.litedesk.litedesk.api.controller;

import om.litedesk.litedesk.api.dto.GeocodingResponse;
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
    public Object getWeather(
            @RequestParam(required = false) String latitude,
            @RequestParam(required = false) String longitude,
            @RequestParam(required = false) String city) {
        if (city != null && !city.isEmpty()) {
            WeatherResponse weather = weatherService.getWeatherByCity(city);
            if (weather != null) {
                GeocodingResponse.GeocodingResult cityResult = weatherService.searchCity(city);
                return new CityWeather(weather, cityResult != null ? cityResult.getDisplayName() : city);
            }
            return new ErrorResponse("City not found");
        }
        if (latitude != null && longitude != null) {
            return weatherService.getWeather(latitude, longitude);
        }
        return new CityWeather(weatherService.getDefaultWeather(), weatherService.getDefaultCityName());
    }

    @GetMapping(path = "/default")
    public Object getDefaultWeather() {
        return new CityWeather(weatherService.getDefaultWeather(), weatherService.getDefaultCityName());
    }

    public record CityWeather(
        String cityName,
        double latitude,
        double longitude,
        WeatherResponse.CurrentWeather current_weather
    ) {
        public CityWeather(WeatherResponse weather, String cityName) {
            this(cityName, weather.getLatitude(), weather.getLongitude(), weather.getCurrent_weather());
        }
    }

    public record ErrorResponse(String error) {}
}