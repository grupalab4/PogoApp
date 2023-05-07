package pl.GrupaC3.PogoApp.service;


import org.springframework.ui.Model;

import java.util.Date;

/**
 * https://powietrze.gios.gov.pl/pjp/content/api
 * Przykład zapytania: https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/400
 * {
 *   "id": 400,
 *   "stCalcDate": "2023-05-07 11:25:07",
 *   "stIndexLevel": {
 *     "id": 0,
 *     "indexLevelName": "Bardzo dobry"
 *   },
 *   "stSourceDataDate": "2023-05-07 11:00:00",
 *   "so2CalcDate": "2023-05-07 11:25:07",
 *   "so2IndexLevel": null,
 *   "so2SourceDataDate": null,
 *   "no2CalcDate": "2023-05-07 11:25:07",
 *   "no2IndexLevel": {
 *     "id": 0,
 *     "indexLevelName": "Bardzo dobry"
 *   },
 *   "no2SourceDataDate": "2023-05-07 11:00:00",
 *   "pm10CalcDate": "2023-05-07 11:25:07",
 *   "pm10IndexLevel": {
 *     "id": 0,
 *     "indexLevelName": "Bardzo dobry"
 *   },
 *   "pm10SourceDataDate": "2023-05-07 11:00:00",
 *   "pm25CalcDate": "2023-05-07 11:25:07",
 *   "pm25IndexLevel": {
 *     "id": 0,
 *     "indexLevelName": "Bardzo dobry"
 *   },
 *   "pm25SourceDataDate": "2023-05-07 11:00:00",
 *   "o3CalcDate": null,
 *   "o3IndexLevel": null,
 *   "o3SourceDataDate": null,
 *   "stIndexStatus": true,
 *   "stIndexCrParam": "OZON"
 * }
 *
 * https://api.gios.gov.pl/pjp-api/swagger-ui/
 */
public class SmogService {
    public static void fillmodelwithSmogData(Model model, int stationID) {
        // informacje o nazwie stacji znajdują się w
        // https://api.gios.gov.pl/pjp-api/rest/station/findAll
        // który zwraca info o wszystkich stacjach, dobrze by było
        // zapamiętać te dane do ponownego przeszukiwania
        model.addAttribute("stationName", "Kraków, Aleja Krasińskiego");
        model.addAttribute("stationCity", "Kraków");

        model.addAttribute("so2IndexLevel", "Bardzo dobry");
        model.addAttribute("no2IndexLevel", "Bardzo dobry");
        model.addAttribute("pm25IndexLevel", "Bardzo dobry");
        model.addAttribute("pm10IndexLevel", "Bardzo dobry");
        model.addAttribute("o3IndexLevel", "Bardzo dobry");
        model.addAttribute("date", ("2023-05-07 11:00:00"));
    }
}
