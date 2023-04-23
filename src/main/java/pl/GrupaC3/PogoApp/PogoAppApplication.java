package pl.GrupaC3.PogoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.GrupaC3.PogoApp.service.WeatherData;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class PogoAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PogoAppApplication.class, args);

        System.out.println(WeatherData.getWeatherDataForLocation("Piaski wielkie wolin").toString());
    }
}
