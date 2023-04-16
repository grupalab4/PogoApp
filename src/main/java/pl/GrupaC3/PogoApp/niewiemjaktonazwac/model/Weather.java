package pl.GrupaC3.PogoApp.niewiemjaktonazwac.model;
public class Weather {
    private Coordinates coords;
    private String name;
    private String datetime;
    private String temp;
    private String pressure;
    private String wind;

    public Weather(Coordinates coords, String name, String datetime, String temp, String pressure, String wind) {
        this.coords = coords;
        this.name = name;
        this.datetime = datetime;
        this.temp = temp;
        this.pressure = pressure;
        this.wind = wind;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "coords=" + coords +
                ", name='" + name + '\'' +
                ", datetime='" + datetime + '\'' +
                ", temp='" + temp + '\'' +
                ", pressure='" + pressure + '\'' +
                ", wind='" + wind + '\'' +
                '}';
    }
}
