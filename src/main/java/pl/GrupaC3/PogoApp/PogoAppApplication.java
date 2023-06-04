package pl.GrupaC3.PogoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.GrupaC3.PogoApp.model.Weather;
import pl.GrupaC3.PogoApp.service.WeatherService;

@SpringBootApplication
public class PogoAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PogoAppApplication.class, args);
        try {
            Weather adasds = WeatherService.getWeatherDataForLocation("piaski wielki wolin");
            System.out.println(adasds.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
