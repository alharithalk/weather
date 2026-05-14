package om.litedesk.litedesk.api.dto;

public class WeatherResponse {
    private double latitude;
    private double longitude;
    private CurrentWeather current_weather;

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public CurrentWeather getCurrent_weather() { return current_weather; }
    public void setCurrent_weather(CurrentWeather current_weather) { this.current_weather = current_weather; }

    public static class CurrentWeather {
        private double temperature;
        private double windspeed;
        private int weathercode;
        private int winddirection;
        private boolean is_day;
        private String time;

        public double getTemperature() { return temperature; }
        public void setTemperature(double temperature) { this.temperature = temperature; }
        public double getWindspeed() { return windspeed; }
        public void setWindspeed(double windspeed) { this.windspeed = windspeed; }
        public int getWeathercode() { return weathercode; }
        public void setWeathercode(int weathercode) { this.weathercode = weathercode; }
        public int getWinddirection() { return winddirection; }
        public void setWinddirection(int winddirection) { this.winddirection = winddirection; }
        public boolean isIs_day() { return is_day; }
        public void setIs_day(boolean is_day) { this.is_day = is_day; }
        public String getTime() { return time; }
        public void setTime(String time) { this.time = time; }
    }
}