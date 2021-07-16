package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.domain.Film;
import be.vdab.retrovideo.domain.Reservatie;
import be.vdab.retrovideo.exceptions.ReservatieException;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.ReservatieService;
import be.vdab.retrovideo.sessions.KlantGekozen;
import be.vdab.retrovideo.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

@Controller
@RequestMapping("rapport")
public class ReservatieController {
    private final ReservatieService reservatieService;
    private final Mandje mandje;
    private final FilmService filmService;
    private final KlantGekozen klantGekozen;

    public ReservatieController(ReservatieService reservatieService, Mandje mandje, FilmService filmService, KlantGekozen klantGekozen) {
        this.reservatieService = reservatieService;
        this.mandje = mandje;
        this.filmService = filmService;
        this.klantGekozen = klantGekozen;
    }

    @PostMapping
    public ModelAndView rapport() {
        var lukteReservaties = new LinkedList<Reservatie>();
        for (var filmId : mandje.getIds()) {
            lukteReservaties.add(new Reservatie(klantGekozen.getKlantId(), filmId));
            filmService.update(filmId);
        }
        var modelAndView = new ModelAndView("rapport");
        if (lukteReservaties.size() > 0) {
            reservatieService.create(lukteReservaties);
        } else {
            modelAndView.addObject("mislukt");
        }
        mandje.reset();
        return modelAndView;
    }
}
