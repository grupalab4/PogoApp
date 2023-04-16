package pl.GrupaC3.PogoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.GrupaC3.PogoApp.service.WeatherData;
import pl.GrupaC3.PogoApp.model.Weather;

import java.util.ArrayList;

@SpringBootApplication
public class PogoAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PogoAppApplication.class, args);

        Weather data = WeatherData.weeklyWeatherDataForLocation("Piaski wielkie wolin");

        System.out.println(data);
    }
}
