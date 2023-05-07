package pl.GrupaC3.PogoApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Optional;

/**
 *   {
 *     "id": 114,
 *     "stationName": "Wrocław, ul. Bartnicza",
 *     "gegrLat": "51.115933",
 *     "gegrLon": "17.141125",
 *     "city": {
 *       "id": 1064,
 *       "name": "Wrocław",
 *       "commune": {
 *         "communeName": "Wrocław",
 *         "districtName": "Wrocław",
 *         "provinceName": "DOLNOŚLĄSKIE"
 *       }
 *     },
 *     "addressStreet": "ul. Bartnicza"
 *   },
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
    public int id;
    public Optional<String> stationName;
    public double gegrLat;
    public double gegrLon;
    public Optional<String> addressStreet;

    public Station() { }
}
