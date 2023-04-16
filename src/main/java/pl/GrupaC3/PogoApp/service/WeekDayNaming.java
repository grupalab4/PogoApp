package pl.GrupaC3.PogoApp.service;

import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class WeekDayNaming {
    private static Locale polish = new Locale("pl", "PL");
    /**
     * function sets `dayOfWeek` on a model to be the name of current day and following six days
     */
    public static void setWeekDayNames(Model model) {
        LocalDateTime today = LocalDateTime.now();
        ArrayList<String> names = new ArrayList<>();
        names.add(today.getDayOfWeek().getDisplayName(TextStyle.FULL, polish));
        names.add(today.plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, polish));
        names.add(today.plusDays(2).getDayOfWeek().getDisplayName(TextStyle.FULL, polish));
        names.add(today.plusDays(3).getDayOfWeek().getDisplayName(TextStyle.FULL, polish));
        names.add(today.plusDays(4).getDayOfWeek().getDisplayName(TextStyle.FULL, polish));
        names.add(today.plusDays(5).getDayOfWeek().getDisplayName(TextStyle.FULL, polish));
        names.add(today.plusDays(6).getDayOfWeek().getDisplayName(TextStyle.FULL, polish));

        model.addAttribute("dayOfWeek", names);
    }
}
