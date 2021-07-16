package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.services.KlantService;
import be.vdab.retrovideo.sessions.KlantGekozen;
import be.vdab.retrovideo.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("bevestigen")
class BevestigenController {
    private final KlantService klantService;
    private final KlantGekozen klantGekozen;
    private final Mandje mandje;

    BevestigenController(KlantService klantService, KlantGekozen klantGekozen, Mandje mandje) {
        this.klantService = klantService;
        this.klantGekozen = klantGekozen;
        this.mandje = mandje;
    }

    @GetMapping("{id}")
    public ModelAndView toonKlantEnFilm(@PathVariable long id) {
        klantGekozen.setKlantId(id);
        return new ModelAndView("bevestigen").addObject("aantalMandje", mandje.aantalFilms())
                .addObject("klantGekozen", klantService.getNaam(klantGekozen.getKlantId()));
    }
}
