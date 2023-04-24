package pl.GrupaC3.PogoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.GrupaC3.PogoApp.service.WeatherService;

@SpringBootApplication
public class PogoAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PogoAppApplication.class, args);

        System.out.println(WeatherService.getWeatherDataForLocation("Piaski wielkie wolin").toString());
    }
}
