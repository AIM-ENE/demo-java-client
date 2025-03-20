package han.aim.se.javaclient;

import com.mashape.unirest.http.exceptions.UnirestException;

public class WeatherClient {

    public static void main(String[] args) throws UnirestException {
        var weatherService = new WeatherServiceUniRest();
         weatherService.getWeatherFor();

        var weatherService2 = new WeatherServiceRestAssured();
        weatherService2.getWeatherFor();
    }
}


