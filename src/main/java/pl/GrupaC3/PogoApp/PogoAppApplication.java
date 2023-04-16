package pl.GrupaC3.PogoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.GrupaC3.PogoApp.niewiemjaktonazwac.WeatherData;
import pl.GrupaC3.PogoApp.niewiemjaktonazwac.model.Weather;

import java.util.ArrayList;

@SpringBootApplication
public class PogoAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PogoAppApplication.class, args);

        ArrayList<Weather> data = WeatherData.weeklyWeatherDataForLocation("Piaski wielkie wolin");

        for(Weather t : data) System.out.println(t.toString());
    }
}
