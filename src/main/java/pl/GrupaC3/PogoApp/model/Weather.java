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

    public List<String> time;
    private List<Double> temp;
    private List<Double> pressure;
    private List<Double> wind;

    public Weather(Coordinates coords, String name) {
        this.coords = coords;
        this.name = name;
        this.time = new ArrayList<>();
        this.temp = new ArrayList<>();
        this.pressure = new ArrayList<>();
        this.wind = new ArrayList<>();
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

    public List<String> getDatetime() {
        return time;
    }

    public void setDatetime(List<String> datetime) {
        this.time = datetime;
    }

    public List<Double> getTemp() {
        return temp;
    }

    public void setTemp(List<Double> temp) {
        this.temp = temp;
    }

    public List<Double> getPressure() {
        return pressure;
    }

    public void setPressure(List<Double> pressure) {
        this.pressure = pressure;
    }

    public List<Double> getWind() {
        return wind;
    }

    public void setWind(List<Double> wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "coords=" + coords +
                ", name='" + name + '\'' +
                ", datetime='" + time + '\'' +
                ", temp='" + temp + '\'' +
                ", pressure='" + pressure + '\'' +
                ", wind='" + wind + '\'' +
                '}';
    }
}
