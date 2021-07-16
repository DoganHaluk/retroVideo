package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.forms.FamilienaamForm;
import be.vdab.retrovideo.services.KlantService;
import be.vdab.retrovideo.sessions.KlantGekozen;
import be.vdab.retrovideo.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("klanten")
class KlantController {
    private final KlantService klantService;
    private final KlantGekozen klantGekozen;
    private final Mandje mandje;

    KlantController(KlantService klantService, KlantGekozen klantGekozen, Mandje mandje) {
        this.klantService = klantService;
        this.klantGekozen = klantGekozen;
        this.mandje = mandje;
    }

    @GetMapping("zoekKlant")
    public ModelAndView familienaamForm() {
        return new ModelAndView("klanten").addObject(new FamilienaamForm(null));
    }

    @GetMapping
    public ModelAndView familienaam(@Valid FamilienaamForm form, Errors errors) {
        var modelAndView = new ModelAndView("klanten");
        if (errors.hasErrors()) {
            return modelAndView;
        }
        return modelAndView.addObject("klantenGevonden", klantService.findByFamilienaamBevat(form.getFamilienaamBevat()));
    }

    @GetMapping("bevestigen/{id}")
    public ModelAndView toonKlantEnFilm(@PathVariable long id) {
        klantGekozen.setKlantId(id);
        return new ModelAndView("bevestigen").addObject("aantalMandje", mandje.aantalFilms())
                .addObject("klantGekozen", klantService.getNaam(klantGekozen.getKlantId()));
    }

}
