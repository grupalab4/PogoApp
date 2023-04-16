package pl.GrupaC3.PogoApp.controller;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.GrupaC3.PogoApp.model.City;
import pl.GrupaC3.PogoApp.model.Smog;

@Controller
public class WeatherControler {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mappingOnWelcome(Model model) {
        City city = new City();
        model.addAttribute("city", city);
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

	@RequestMapping("/smogkrakow")
    public String smogkrakow(Model model) {
        return "smogkrakow";
    }

    private void addAttributeToModelWelcome(Model model, Smog smog, City city) {
        model.addAttribute("Sensor1", smog.getAmountUGM3(0));
        model.addAttribute("Sensor2", smog.getAmountUGM3(1));
        model.addAttribute("Sensor3", smog.getAmountUGM3(2));
        model.addAttribute("Sensor4", smog.getAmountUGM3(3));
        model.addAttribute("Sensor5", smog.getAmountUGM3(4));
        model.addAttribute("Sensor6", smog.getAmountUGM3(5));
        model.addAttribute("city", city);

    }
}
