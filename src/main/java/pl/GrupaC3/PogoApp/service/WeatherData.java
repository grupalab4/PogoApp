package pl.GrupaC3.PogoApp.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.GrupaC3.PogoApp.model.Coordinates;
import pl.GrupaC3.PogoApp.model.Weather;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherData {
    public static Weather weeklyWeatherDataForLocation(String location) {
        ObjectMapper objectMapper = new ObjectMapper();
        Coordinates coords = GPSCoordinates.getCoordinatesForLocation(location);
        Weather result = new Weather(coords, location);

        String link = "https://api.open-meteo.com/v1/forecast?latitude=" +
                coords.getLatitude() +
                "&longitude=" +
                coords.getLongitude() +
                "&hourly=temperature_2m,surface_pressure,windspeed_10m";

        try {
            JsonNode json = objectMapper.readTree(new URL(link));

            List<String> datetime = objectMapper.convertValue(json.get("hourly").get("time"), ArrayList.class);
            result.setDatetime(datetime);
            List<Double> temp = objectMapper.convertValue(json.get("hourly").get("temperature_2m"), ArrayList.class);
            result.setTemp(temp);
            List<Double> pressure = objectMapper.convertValue(json.get("hourly").get("surface_pressure"), ArrayList.class);
            result.setPressure(pressure);
            List<Double> wind = objectMapper.convertValue(json.get("hourly").get("windspeed_10m"), ArrayList.class);
            result.setWind(wind);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("location not found");
        }

        return result;
    }
}
