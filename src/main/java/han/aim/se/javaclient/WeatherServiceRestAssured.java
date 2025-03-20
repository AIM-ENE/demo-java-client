package han.aim.se.javaclient;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherServiceRestAssured extends WeatherService {

    @Override
    public void getWeatherFor()  {

        var request = currentWeatherEndpoint + coordinate;

        // Make the request using RestAssured
        Response response = RestAssured.given()
        .header("x-rapidapi-key", apiKey)
        .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
        .when()
        .get(request)
        .then()
        .extract()
        .response();

        // {"location":{"name":"Elst","region":"Gelderland","country":"Netherlands","lat":51.89,"lon":5.9}
        // System.out.println(response.getBody());
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        var parser = new WeatherJsonParser();
        parser.getLocationAndTemperature(response.getBody().asString());
    }

}
