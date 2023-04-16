package pl.GrupaC3.PogoApp.niewiemjaktonazwac;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.GrupaC3.PogoApp.niewiemjaktonazwac.model.Coordinates;
import pl.GrupaC3.PogoApp.niewiemjaktonazwac.model.Weather;

import java.net.URL;
import java.util.ArrayList;

public class WeatherData {
    public static ArrayList<Weather> weeklyWeatherDataForLocation(String location) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Weather> result = new ArrayList<>();
        Coordinates coords = GPSCoordinates.getCoordinatesForLocation(location);

        String link = "https://api.open-meteo.com/v1/forecast?latitude=" +
                coords.getLatitude() +
                "&longitude=" +
                coords.getLongitude() +
                "&hourly=temperature_2m,surface_pressure,windspeed_10m";

        try {
            JsonNode json = objectMapper.readTree(new URL(link));

            JsonNode time = json.get("hourly").get("time");
            JsonNode temperature = json.get("hourly").get("temperature_2m");
            JsonNode pressure = json.get("hourly").get("surface_pressure");
            JsonNode wind = json.get("hourly").get("windspeed_10m");

            for(int i = 0; i<time.size(); i++) {
                result.add(new Weather(
                        coords,
                        location,
                        time.get(i).asText(),
                        temperature.get(i).asText(),
                        pressure.get(i).asText(),
                        wind.get(i).asText()
                ));
            }

        } catch (Exception e) {
            System.out.println("location not found");
        }

        return result;
    }
}
