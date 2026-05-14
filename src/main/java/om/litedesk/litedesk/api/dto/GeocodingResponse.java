package om.litedesk.litedesk.api.dto;

import java.util.List;

public class GeocodingResponse {
    private List<GeocodingResult> results;

    public List<GeocodingResult> getResults() { return results; }
    public void setResults(List<GeocodingResult> results) { this.results = results; }

    public static class GeocodingResult {
        private String name;
        private String country;
        private String admin1;
        private double latitude;
        private double longitude;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
        public String getAdmin1() { return admin1; }
        public void setAdmin1(String admin1) { this.admin1 = admin1; }
        public double getLatitude() { return latitude; }
        public void setLatitude(double latitude) { this.latitude = latitude; }
        public double getLongitude() { return longitude; }
        public void setLongitude(double longitude) { this.longitude = longitude; }

        public String getDisplayName() {
            StringBuilder sb = new StringBuilder(name);
            if (admin1 != null && !admin1.isEmpty()) sb.append(", ").append(admin1);
            if (country != null && !country.isEmpty()) sb.append(", ").append(country);
            return sb.toString();
        }
    }
}