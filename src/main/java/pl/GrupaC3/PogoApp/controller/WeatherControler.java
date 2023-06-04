package pl.GrupaC3.PogoApp.controller;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.GrupaC3.PogoApp.model.City;
import pl.GrupaC3.PogoApp.model.Smog;
import pl.GrupaC3.PogoApp.service.SmogService;
import pl.GrupaC3.PogoApp.service.WeatherService;
import pl.GrupaC3.PogoApp.service.WeekDayNaming;

@Controller
public class WeatherControler {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mappingOnWelcome(Model model, @CookieValue(defaultValue = "Kraków") String preffered_location) {
        City city = new City();
        model.addAttribute("city", city);
        model.addAttribute("command", city); // nie mam pojęcia po co to, ale bez tego nie działa...
        model.addAttribute("banner_picture", "cities/Krakow.jpg");
        WeekDayNaming.setWeekDayNames(model);
        WeatherService.fillModelWithWeatherData(model, preffered_location);
        return "index";
    }

    @RequestMapping("/peaks")
    public String peaks(Model model) {
        model.addAttribute("greeting", "Witaj");
        return "peaks";
    }

    @RequestMapping("/weekendWeather")
    public String weekendWeatherEntry(Model model) {
        model.addAttribute("greeting", "Witaj");
        return "weekendWeather";
    }

    @RequestMapping("/authors")
    public String authors(Model model) {
        model.addAttribute("greeting", "Witaj");
        return "authors";
    }

    @RequestMapping("/smog")
    public String smogkrakow(Model model, @RequestParam(defaultValue = "Kraków") String name) {
        SmogService.fillmodelwithSmogData(model, name);
        return "smog";
    }

    @GetMapping("/weather")
    public String mappingOnCity(Model model, String name) {
        WeatherService.fillModelWithWeatherData(model, name);
        WeekDayNaming.setWeekDayNames(model);
        return "weather";
    }
}
