package pl.GrupaC3.PogoApp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.ui.Model;
import pl.GrupaC3.PogoApp.model.Coordinates;
import pl.GrupaC3.PogoApp.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherService {
    public static Weather getWeatherDataForLocation(String location) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Coordinates coords = GPSCoordinates.getCoordinatesForLocation(location);
        Weather result = new Weather(coords);

        String link = "https://api.open-meteo.com/v1/forecast?latitude=" +
                coords.getLatitude() +
                "&longitude=" +
                coords.getLongitude() +
                "&daily=temperature_2m_max,windspeed_10m_max,sunrise,sunset,precipitation_probability_max" +
                "&hourly=surface_pressure,temperature_2m,windspeed_10m,precipitation,cloudcover" +
                "&timezone=Europe%2FWarsaw";

        try {
            JsonNode json = objectMapper.readTree(new URL(link));

            System.out.println(json.toPrettyString());

            List<String> sunriseDaily = objectMapper.convertValue(json.get("daily").get("sunrise"), ArrayList.class);
            result.setSunriseDaily(sunriseDaily);

            List<String> sunsetDaily = objectMapper.convertValue(json.get("daily").get("sunset"), ArrayList.class);
            result.setSunsetDaily(sunsetDaily);

            List<String> dateDaily = objectMapper.convertValue(json.get("daily").get("time"), ArrayList.class);
            result.setDateDaily(dateDaily);

            List<Double> temperatureDaily = objectMapper.convertValue(json.get("daily").get("temperature_2m_max"), ArrayList.class);
            result.setTemperatureDaily(temperatureDaily);

            List<Double> pressureDaily = objectMapper.convertValue(json.get("hourly").get("surface_pressure"), ArrayList.class);
            result.setPressureDaily(averagePressures(pressureDaily));

            List<Double> windDaily = objectMapper.convertValue(json.get("daily").get("windspeed_10m_max"), ArrayList.class);
            result.setWindDaily(windDaily);

            List<Integer> precipitationProbabilityDaily = objectMapper.convertValue(json.get("daily").get("precipitation_probability_max"), ArrayList.class);
            result.setPrecipitationProbabilityDaily(precipitationProbabilityDaily);

            int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

            List<String> timeHourly = objectMapper.convertValue(json.get("hourly").get("time"), ArrayList.class);
            List<Double> temperatureHourly = objectMapper.convertValue(json.get("hourly").get("temperature_2m"), ArrayList.class);
            List<Double> windHourly = objectMapper.convertValue(json.get("hourly").get("windspeed_10m"), ArrayList.class);
            List<Double> precipitationHourly = objectMapper.convertValue(json.get("hourly").get("precipitation"), ArrayList.class);
            List<Integer> cloudCoverHourly = objectMapper.convertValue(json.get("hourly").get("cloudcover"), ArrayList.class);

            ArrayList<String> time24H = new ArrayList<>();
            ArrayList<Double> temperature24H = new ArrayList<>();
            ArrayList<Double> wind24H = new ArrayList<>();
            ArrayList<Double> precipitation24H = new ArrayList<>();
            ArrayList<Integer> cloudCover24H = new ArrayList<>();

            for (int i = currentHour; i < currentHour + 24; i++) {
                time24H.add(timeHourly.get(i));
                temperature24H.add(temperatureHourly.get(i));
                wind24H.add(windHourly.get(i));
                precipitation24H.add(precipitationHourly.get(i));
                cloudCover24H.add(cloudCoverHourly.get(i));
            }

            result.setTimeHourly(time24H);
            result.setTemperatureHourly(temperature24H);
            result.setWindHourly(wind24H);
            result.setPrecipitationHourly(precipitation24H);
            result.setCloudCoverHourly(cloudCover24H);

        } catch (Exception e) {
            throw new RuntimeException("received invalid or malformed JSON from Meteo API");
        }

        return result;
    }

    private static List<Double> averagePressures(List<Double> pressureList) {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            double sum = 0;
            sum += pressureList.get(i);
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

    private static ArrayList<String> fillWeatherIconsHourly(Weather weather) {
        ArrayList<String> result = new ArrayList<>();

        int sunriseToday = new DateTime(weather.getSunriseDaily().get(0)).getHourOfDay();
        int sunsetToday = new DateTime(weather.getSunsetDaily().get(0)).getHourOfDay();

        int sunriseTomorrow = new DateTime(weather.getSunriseDaily().get(1)).getHourOfDay() + 24;
        int sunsetTomorrow = new DateTime(weather.getSunsetDaily().get(1)).getHourOfDay() + 24;

        boolean isCloudy;
        boolean precipitation;
        boolean isSnowPossible;
        boolean isDay;

        for (int i = 0; i < 24; i++) {
            int currentHour = new DateTime(weather.getTimeHourly().get(i)).getHourOfDay();

            if (currentHour == sunriseToday || currentHour == sunsetToday || currentHour == sunriseTomorrow - 24 || currentHour == sunsetTomorrow - 24) {
                result.add("sunrise");
                continue;
            }

            if (currentHour > sunriseToday && currentHour < sunsetToday) isDay = true;
            else if (currentHour > sunsetToday && currentHour < sunriseTomorrow) isDay = false;
            else if (currentHour > sunriseTomorrow && currentHour < sunsetTomorrow) isDay = true;
            else isDay = false;

            if (weather.getCloudCoverHourly().get(i) > 0) isCloudy = true;
            else isCloudy = false;

            if (weather.getPrecipitationHourly().get(i) > 0) precipitation = true;
            else precipitation = false;

            if (weather.getTemperatureHourly().get(i) <= -3) isSnowPossible = true;
            else isSnowPossible = false;

            if (!isCloudy && !precipitation) {
                if (isDay) result.add("sun");
                else result.add("moon");
            } else if (isCloudy && !precipitation) {
                if (isDay) {
                    if (weather.getCloudCoverHourly().get(i) >= 90) result.add("cloud");
                    else result.add("sun_clouds");
                } else {
                    if (weather.getCloudCoverHourly().get(i) >= 50) result.add("cloud_moon");
                    else result.add("moon");
                }
            } else {
                if (isSnowPossible) {
                    if (weather.getPrecipitationHourly().get(i) <= 0.3) result.add("snow_small");
                    else result.add("snow");
                } else {
                    if (weather.getPrecipitationHourly().get(i) <= 0.3) result.add("rain_small");
                    else result.add("rain");
                }
            }
        }

        return result;
    }

    private static ArrayList<String> fillWeatherIconsWeekly(Weather weather) {
        ArrayList<String> result = new ArrayList<>();

        boolean isPrecipitationProbable;
        boolean isSnowPossible;

        for (int i = 0; i < 7; i++) {
            if (weather.getPrecipitationProbabilityDaily().get(i) > 10) isPrecipitationProbable = true;
            else isPrecipitationProbable = false;

            if (weather.getTemperatureDaily().get(i) <= -3) isSnowPossible = true;
            else isSnowPossible = false;

            if (isPrecipitationProbable) {
                if (weather.getPrecipitationProbabilityDaily().get(i) <= 65) result.add("sun_clouds");

                else {
                    if (isSnowPossible) result.add("snow");
                    else result.add("rain");
                }
            } else {
                result.add("sun");
            }
        }

        return result;
    }

    public static void fillModelWithWeatherData(Model model, String loc) throws IOException {
        Weather weather = getWeatherDataForLocation(loc);
        if (weather.getName() == "ERROR") return;

        ArrayList<String> predictionHourly = fillWeatherIconsHourly(weather);
        ArrayList<String> predictionWeekly = fillWeatherIconsWeekly(weather);

        model.addAttribute("pressure", weather.getPressureDaily());
        model.addAttribute("prediction", predictionWeekly);
        model.addAttribute("temperature", weather.getTemperatureDaily());
        model.addAttribute("wind", weather.getWindDaily());
        model.addAttribute("city", weather.getName());
        model.addAttribute("calendar", weather.getDateDaily());

        model.addAttribute("hours",
                weather.getTimeHourly()
                        .stream()
                        .map(timestr -> timestr.substring(11))
                        .collect(Collectors.toList())
        );
        model.addAttribute("hourly_prediction", predictionHourly);
        model.addAttribute("hourly_temperature", weather.getTemperatureHourly());
        model.addAttribute("hourly_wind", weather.getWindHourly());
        model.addAttribute("banner_picture", chooseBackgroundImage(weather.getName()));
    }

    public static String chooseBackgroundImage(String locationName) {
        String result = "cities/";
        locationName = locationName.toLowerCase();

        if(locationName.contains("zakopane")) result += "Zakopane";
        else if(locationName.contains("zachodniopomorskie") || locationName.contains("szczecin")) result += "Szczecin";
        else if(locationName.contains("kujawsko-pomorskie") || locationName.contains("bydgoszcz")) result += "Bydgoszcz";
        else if(locationName.contains("pomorskie") || locationName.contains("gdańsk")) result += "Gdansk";
        else if(locationName.contains("dolnośląskie") || locationName.contains("wrocław")) result += "Wroclaw";
        else if(locationName.contains("śląskie") || locationName.contains("katowice")) result += "Katowice";
        else if(locationName.contains("lubelskie") || locationName.contains("lublin")) result += "Lublin";
        else if(locationName.contains("lubuskie") || locationName.contains("zielona góra")) result += "Zielona_gora";
        else if(locationName.contains("łódzkie") || locationName.contains("łódź")) result += "Lodz";
        else if(locationName.contains("małopolskie") || locationName.contains("kraków")) result += "Krakow";
        else if(locationName.contains("wielkopolskie") || locationName.contains("poznań")) result += "Poznan";
        else if(locationName.contains("opolskie") || locationName.contains("opole")) result += "Opole";
        else if(locationName.contains("mazowieckie") || locationName.contains("warszawa")) result += "Warszawa";
        else if(locationName.contains("podkarpackie") || locationName.contains("rzeszów")) result += "Rzeszow";
        else if(locationName.contains("podlaskie") || locationName.contains("białystok")) result += "Bialystok";
        else if(locationName.contains("świętokrzyskie") || locationName.contains("kielce")) result += "Kielce";
        else if(locationName.contains("warmińsko-mazurskie") || locationName.contains("olsztyn")) result += "Olsztyn";

        else return "weather.jpg";

        result += ".jpg";
        System.out.println(result);
        return result;
    }
}
