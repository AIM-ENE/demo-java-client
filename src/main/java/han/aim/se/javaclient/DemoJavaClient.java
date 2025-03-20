package han.aim.se.javaclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class DemoJavaClient {
    public static void main(String[] args) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/current.json?q=51.892601%2C5.896940")
                .header("x-rapidapi-key", "5d378c7734msh6d03487e9dcf1ddp113adjsnd03a0fdb3214")
                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
                .asString();

        // {"location":{"name":"Elst","region":"Gelderland","country":"Netherlands","lat":51.89,"lon":5.9}
        System.out.println(response.getBody());
    }
}
