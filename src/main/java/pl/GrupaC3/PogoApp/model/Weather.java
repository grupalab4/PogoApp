package pl.GrupaC3.PogoApp.model;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    private Coordinates coords;
    private String name;

    private List<String> sunriseDaily;
    private List<String> sunsetDaily;
    private List<String> dateDaily;
    private List<Double> temperatureDaily;
    private List<Double> pressureDaily;
    private List<Double> windDaily;
    private List<Integer> precipitationProbabilityDaily;

    private List<String> timeHourly;
    private List<Double> temperatureHourly;
    private List<Double> windHourly;
    private List<Double> precipitationHourly;
    private List<Integer> cloudCoverHourly;

    public Weather(Coordinates coords) {
        this.coords = coords;
        this.name = coords.getDisplayName();

        this.sunriseDaily = new ArrayList<>();
        this.sunsetDaily = new ArrayList<>();
        this.dateDaily = new ArrayList<>();
        this.temperatureDaily = new ArrayList<>();
        this.pressureDaily = new ArrayList<>();
        this.windDaily = new ArrayList<>();
        this.precipitationProbabilityDaily = new ArrayList<>();

        this.timeHourly = new ArrayList<>();
        this.temperatureHourly = new ArrayList<>();
        this.windHourly = new ArrayList<>();
        this.precipitationHourly = new ArrayList<>();
        this.cloudCoverHourly = new ArrayList<>();
    }

    public Coordinates getCoords() {
        return coords;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDateDaily() {
        return dateDaily;
    }

    public void setDateDaily(List<String> dateDaily) {
        this.dateDaily = dateDaily;
    }

    public List<Double> getTemperatureDaily() {
        return temperatureDaily;
    }

    public void setTemperatureDaily(List<Double> temperatureDaily) {
        this.temperatureDaily = temperatureDaily;
    }

    public List<Double> getPressureDaily() {
        return pressureDaily;
    }

    public void setPressureDaily(List<Double> pressureDaily) {
        this.pressureDaily = pressureDaily;
    }

    public List<Double> getWindDaily() {
        return windDaily;
    }

    public void setWindDaily(List<Double> windDaily) {
        this.windDaily = windDaily;
    }

    public List<String> getTimeHourly() {
        return timeHourly;
    }

    public void setTimeHourly(List<String> timeHourly) {
        this.timeHourly = timeHourly;
    }

    public List<Double> getTemperatureHourly() {
        return temperatureHourly;
    }

    public void setTemperatureHourly(List<Double> temperatureHourly) {
        this.temperatureHourly = temperatureHourly;
    }

    public List<Double> getWindHourly() {
        return windHourly;
    }

    public void setWindHourly(List<Double> windHourly) {
        this.windHourly = windHourly;
    }

    public List<Double> getPrecipitationHourly() {
        return precipitationHourly;
    }

    public void setPrecipitationHourly(List<Double> precipitationHourly) {
        this.precipitationHourly = precipitationHourly;
    }

    public List<Integer> getCloudCoverHourly() {
        return cloudCoverHourly;
    }

    public void setCloudCoverHourly(List<Integer> cloudCoverHourly) {
        this.cloudCoverHourly = cloudCoverHourly;
    }

    public List<String> getSunriseDaily() {
        return sunriseDaily;
    }

    public void setSunriseDaily(List<String> sunriseDaily) {
        this.sunriseDaily = sunriseDaily;
    }

    public List<String> getSunsetDaily() {
        return sunsetDaily;
    }

    public void setSunsetDaily(List<String> sunsetDaily) {
        this.sunsetDaily = sunsetDaily;
    }

    public List<Integer> getPrecipitationProbabilityDaily() {
        return precipitationProbabilityDaily;
    }

    public void setPrecipitationProbabilityDaily(List<Integer> precipitationProbabilityDaily) {
        this.precipitationProbabilityDaily = precipitationProbabilityDaily;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "coords=" + coords +
                ", name='" + name + '\'' +
                ", dateDaily=" + dateDaily +
                ", temperatureDaily=" + temperatureDaily +
                ", pressureDaily=" + pressureDaily +
                ", windDaily=" + windDaily +
                ", timeHourly=" + timeHourly +
                ", temperatureHourly=" + temperatureHourly +
                ", windHourly=" + windHourly +
                '}';
    }
}
