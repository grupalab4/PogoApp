package pl.GrupaC3.PogoApp.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
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
                "&daily=temperature_2m_max,windspeed_10m_max,precipitation_probability_max" +
                "&hourly=surface_pressure" +
                "&timezone=Europe%2FWarsaw";

        try {
            JsonNode json = objectMapper.readTree(new URL(link));
            System.out.println(json.toPrettyString());

            List<String> datetime = objectMapper.convertValue(json.get("daily").get("time"), ArrayList.class);
            result.setDatetime(datetime);

            List<Double> temp = objectMapper.convertValue(json.get("daily").get("temperature_2m_max"), ArrayList.class);
            result.setTemp(temp);

            List<Double> pressure = objectMapper.convertValue(json.get("hourly").get("surface_pressure"), ArrayList.class);
            result.setPressure(averagePressures(pressure));

            List<Double> wind = objectMapper.convertValue(json.get("daily").get("windspeed_10m_max"), ArrayList.class);
            result.setWind(wind);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("location not found");
        }

        return result;
    }

    private static List<Double> averagePressures(List<Double> pressureList) {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            double sum = 0;
            sum += pressureList.get(i)    ;
            sum += pressureList.get(i + 1);
            sum += pressureList.get(i + 2);
            sum += pressureList.get(i + 3);
            sum += pressureList.get(i + 4);
            sum += pressureList.get(i + 5);
            sum += pressureList.get(i + 6);

            result.add(Math.round(sum / 7 * 100d) / 100d);
        }

        return result;
    }

    public static void fillModelWithWeatherData(Model model, String loc) {
        Weather weather = weeklyWeatherDataForLocation(loc);
        ArrayList<String> prediction = new ArrayList<>();
        prediction.add("Zachmurzenie całkowite");
        prediction.add("Pochmurno, słabe opady deszczu");
        prediction.add("Pogodnie");
        prediction.add("Pogodnie, okresami wzrost zachmurzenia do umiarkowanego");
        prediction.add("Zachmurzenie małe, możliwe słabe opady deszczu");
        prediction.add("Pochmurno z przejaśnieniami, słabe opady deszczu");
        prediction.add("Pochmurno, okresami przejaśnienia");

        model.addAttribute("pressure", weather.getPressure());
        model.addAttribute("prediction", prediction);
        model.addAttribute("temperature", weather.getTemp());
        model.addAttribute("wind", weather.getWind());
        model.addAttribute("city", weather.getName());
        model.addAttribute("calendar", weather.getDatetime());
    }
}
