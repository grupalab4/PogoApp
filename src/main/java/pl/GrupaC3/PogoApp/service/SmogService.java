package pl.GrupaC3.PogoApp.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.sun.tools.jconsole.JConsoleContext;
import org.apache.jasper.tagplugins.jstl.core.Param;
import org.springframework.ui.Model;
import pl.GrupaC3.PogoApp.model.Coordinates;
import pl.GrupaC3.PogoApp.model.Smog;
import pl.GrupaC3.PogoApp.model.Station;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.SynchronousQueue;
import java.util.regex.Pattern;

/**
 * https://powietrze.gios.gov.pl/pjp/content/api
 * Przykład zapytania: https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/400
 * {
 * "id": 400,
 * "stCalcDate": "2023-05-07 11:25:07",
 * "stIndexLevel": {
 * "id": 0,
 * "indexLevelName": "Bardzo dobry"
 * },
 * "stSourceDataDate": "2023-05-07 11:00:00",
 * "so2CalcDate": "2023-05-07 11:25:07",
 * "so2IndexLevel": null,
 * "so2SourceDataDate": null,
 * "no2CalcDate": "2023-05-07 11:25:07",
 * "no2IndexLevel": {
 * "id": 0,
 * "indexLevelName": "Bardzo dobry"
 * },
 * "no2SourceDataDate": "2023-05-07 11:00:00",
 * "pm10CalcDate": "2023-05-07 11:25:07",
 * "pm10IndexLevel": {
 * "id": 0,
 * "indexLevelName": "Bardzo dobry"
 * },
 * "pm10SourceDataDate": "2023-05-07 11:00:00",
 * "pm25CalcDate": "2023-05-07 11:25:07",
 * "pm25IndexLevel": {
 * "id": 0,
 * "indexLevelName": "Bardzo dobry"
 * },
 * "pm25SourceDataDate": "2023-05-07 11:00:00",
 * "o3CalcDate": null,
 * "o3IndexLevel": null,
 * "o3SourceDataDate": null,
 * "stIndexStatus": true,
 * "stIndexCrParam": "OZON"
 * }
 * <p>
 * https://api.gios.gov.pl/pjp-api/swagger-ui/
 */
public class SmogService {
    private static ArrayList<Station> stations = null;

    public static <T> T fromJSON(final TypeReference<T> type,
                                 final URL jsonPacket) {
        T data = null;

        try {
            var mapper = new ObjectMapper();
            mapper.registerModule(new Jdk8Module());
            data = mapper.readValue(jsonPacket, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    private static void collectStations() {
        String link = "https://api.gios.gov.pl/pjp-api/rest/station/findAll";

        try {
            stations = fromJSON(new TypeReference<>() {
            }, new URL(link));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Station> findStations(String query) {
        if (stations == null) {
            collectStations();
        }
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        List<Station> matching = new ArrayList<>();
        for (var station :
                stations) {
            if(pattern.matcher(station.stationName.orElse("")).find()) {
                matching.add(station);
            } else if(pattern.matcher(station.addressStreet.orElse("")).find()) {
                matching.add(station);
            }
            if(matching.size() > 15) {
                break;
            }
        }

        return matching;
    }

    private static Smog getSmogData(Station station) {
        String link ="https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/" + station.id;

        try{
            return fromJSON(new TypeReference<>(){}, new URL(link));
        } catch (MalformedURLException e) {
            System.out.println("invalid url: " + link);
        }

        return null;
    }
    public static void fillmodelwithSmogData(Model model, String name) {
        Vector<Smog> smogData = new Vector<>();
        SmogService.findStations(name).parallelStream().forEach((station -> {
            var smog = getSmogData(station);
            System.out.println("adding: " + station.stationName);
            smog.stationName = station.stationName.orElse("Brak danych");
            smogData.add(smog);
        }));
        model.addAttribute("smog_data", smogData);
        model.addAttribute("banner_picture", WeatherService.chooseBackgroundImage(name));
    }
}
