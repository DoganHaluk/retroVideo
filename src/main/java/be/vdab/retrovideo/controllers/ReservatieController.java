package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.domain.Reservatie;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.ReservatieService;
import be.vdab.retrovideo.sessions.KlantGekozen;
import be.vdab.retrovideo.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        var modelAndView = new ModelAndView("rapport");
        List<Long> mislukteReservatieIds = mandje.getIds().stream()
                .filter(id -> !filmService.findById(id).get().isBeschikbaar())
                .collect(Collectors.toList());
        var mislukteReservaties = new LinkedList<String>();
        for (var filmId : mislukteReservatieIds) {
            mislukteReservaties.add(filmService.findById(filmId).get().getTitel());
        }
        modelAndView.addObject("mislukt", mislukteReservaties);

        List<Long> lukteReservatieIds = mandje.getIds().stream()
                .filter(id -> filmService.findById(id).get().isBeschikbaar())
                .collect(Collectors.toList());
        var lukteReservaties = new LinkedList<Reservatie>();
        for (var filmId : lukteReservatieIds) {
            lukteReservaties.add(new Reservatie(klantGekozen.getKlantId(), filmId));
            filmService.update(filmId);
        }
        reservatieService.create(lukteReservaties);

        mandje.reset();
        return modelAndView;
    }
}
