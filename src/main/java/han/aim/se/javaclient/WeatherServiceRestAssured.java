package han.aim.se.javaclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class WeatherServiceRestAssured extends WeatherService {

    @Override
    public void getWeatherFor() throws UnirestException {

        var request = currentWeatherEndpoint + coordinate;

        HttpResponse<String> response = Unirest.get(request)
                .header("x-rapidapi-key", apiKey)
                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
                .asString();

        // {"location":{"name":"Elst","region":"Gelderland","country":"Netherlands","lat":51.89,"lon":5.9}
        // System.out.println(response.getBody());
        var parser = new WeatherJsonParser();
        parser.getLocationAndTemperature(response.getBody());
    }

}
