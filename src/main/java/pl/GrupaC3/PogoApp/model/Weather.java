package pl.GrupaC3.PogoApp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    private Coordinates coords;
    private String name;

    private List<String> dateWeekly;
    private List<Double> temperatureWeekly;
    private List<Double> pressureWeekly;
    private List<Double> windWeekly;

    private List<String> timeDaily;
    private List<Double> temperatureDaily;
    private List<Double> windDaily;

    public Weather(Coordinates coords) {
        this.coords = coords;
        this.name = coords.getDisplayName();

        this.dateWeekly = new ArrayList<>();
        this.temperatureWeekly = new ArrayList<>();
        this.pressureWeekly = new ArrayList<>();
        this.windWeekly = new ArrayList<>();

        this.timeDaily = new ArrayList<>();
        this.temperatureDaily = new ArrayList<>();
        this.windDaily = new ArrayList<>();
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

    public List<String> getDateWeekly() {
        return dateWeekly;
    }

    public void setDateWeekly(List<String> dateWeekly) {
        this.dateWeekly = dateWeekly;
    }

    public List<Double> getTemperatureWeekly() {
        return temperatureWeekly;
    }

    public void setTemperatureWeekly(List<Double> temperatureWeekly) {
        this.temperatureWeekly = temperatureWeekly;
    }

    public List<Double> getPressureWeekly() {
        return pressureWeekly;
    }

    public void setPressureWeekly(List<Double> pressureWeekly) {
        this.pressureWeekly = pressureWeekly;
    }

    public List<Double> getWindWeekly() {
        return windWeekly;
    }

    public void setWindWeekly(List<Double> windWeekly) {
        this.windWeekly = windWeekly;
    }

    public List<String> getTimeDaily() {
        return timeDaily;
    }

    public void setTimeDaily(List<String> timeDaily) {
        this.timeDaily = timeDaily;
    }

    public List<Double> getTemperatureDaily() {
        return temperatureDaily;
    }

    public void setTemperatureDaily(List<Double> temperatureDaily) {
        this.temperatureDaily = temperatureDaily;
    }

    public List<Double> getWindDaily() {
        return windDaily;
    }

    public void setWindDaily(List<Double> windDaily) {
        this.windDaily = windDaily;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "coords=" + coords +
                ", name='" + name + '\'' +
                ", dateWeekly=" + dateWeekly +
                ", temperatureWeekly=" + temperatureWeekly +
                ", pressureWeekly=" + pressureWeekly +
                ", windWeekly=" + windWeekly +
                ", timeDaily=" + timeDaily +
                ", temperatureDaily=" + temperatureDaily +
                ", windDaily=" + windDaily +
                '}';
    }
}
