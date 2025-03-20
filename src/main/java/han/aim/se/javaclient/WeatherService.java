package han.aim.se.javaclient;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class WeatherService {
    protected String baseUrl = "https://weatherapi-com.p.rapidapi.com";
    protected String apiKey;
   protected String currentWeatherEndpoint;
    protected String coordinate;


    abstract void getWeatherFor() throws UnirestException;

    public WeatherService() {
        this.apiKey = loadApiKey();

        var baseUrl = "https://weatherapi-com.p.rapidapi.com";

        // Arnhem: lat: 51.98 lon: 5.91,
        // Nijmegen: lat: 51.84, lon: 5.85
        // Elst:
        float lat = 51.892601f;
        float lon = 5.896940f;
        var separator = "%2C";

        coordinate = lat  + separator + lon;
        currentWeatherEndpoint = baseUrl + "/current.json?q=";
    }

    private String loadApiKey() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find application.properties");
            }
            properties.load(input);
            return properties.getProperty("api.key");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load API key from properties file", e);
        }
    }
}

