package han.aim.se.javaclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherJsonParser {

    public WeatherData getLocationAndTemperature() {
        return getLocationAndTemperature("{\"location\":{\"name\":\"Elst\",\"region\":\"Gelderland\",\"country\":\"Netherlands\",\"lat\":51.919,\"lon\":5.842,\"tz_id\":\"Europe/Amsterdam\",\"localtime_epoch\":1742222858,\"localtime\":\"2025-03-17 15:47\"},\"current\":{\"last_updated_epoch\":1742222700,\"last_updated\":\"2025-03-17 15:45\",\"temp_c\":9.3,\"temp_f\":48.7,\"is_day\":1,\"condition\":{\"text\":\"Sunny\",\"icon\":\"//cdn.weatherapi.com/weather/64x64/day/113.png\",\"code\":1000},\"wind_mph\":15.0,\"wind_kph\":24.1,\"wind_degree\":79,\"wind_dir\":\"E\",\"pressure_mb\":1029.0,\"pressure_in\":30.39,\"precip_mm\":0.0,\"precip_in\":0.0,\"humidity\":34,\"cloud\":0,\"feelslike_c\":6.1,\"feelslike_f\":43.0,\"windchill_c\":5.6,\"windchill_f\":42.0,\"heatindex_c\":8.9,\"heatindex_f\":48.0,\"dewpoint_c\":-3.6,\"dewpoint_f\":25.5,\"vis_km\":10.0,\"vis_miles\":6.0,\"uv\":2.1,\"gust_mph\":17.9,\"gust_kph\":28.8}}");
    }

    public WeatherData getLocationAndTemperature(String jsonInput) {
        String locationName;
        double temperatureCelsius;

        try {

            // Initialize Jackson ObjectMapper
            var objectMapper = new ObjectMapper();

            // Parse JSON string into JsonNode
            var rootNode = objectMapper.readTree(jsonInput);

            // Extract "name" from "location".
            locationName = rootNode.path("location").path("name").asText();

            // Extract "temp_c" from "current"
            temperatureCelsius = rootNode.path("current").path("temp_c").asDouble();

            // Print extracted values
            System.out.println("Location Name: " + locationName);
            System.out.println("Temperature (°C): " + temperatureCelsius);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return new WeatherData(locationName, temperatureCelsius);
    }
}
