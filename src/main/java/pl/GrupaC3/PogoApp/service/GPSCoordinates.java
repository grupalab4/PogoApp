package pl.GrupaC3.PogoApp.service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.GrupaC3.PogoApp.model.Coordinates;

import java.net.URL;

public class GPSCoordinates {
    public static Coordinates getCoordinatesForLocation(String location) {
        ObjectMapper objectMapper = new ObjectMapper();
        Coordinates coords = new Coordinates();

        String link = "https://nominatim.openstreetmap.org/search.php?q="
                + location.replace(' ', '+')
                + "&format=jsonv2";

        try {
            JsonNode result = objectMapper.readTree(new URL(link));

            coords.setLatitude(result.get(0).get("lat").asText());
            coords.setLongitude(result.get(0).get("lon").asText());
        } catch (Exception e) {
            return new Coordinates("not", "found");
        }

        return coords;
    }
}
