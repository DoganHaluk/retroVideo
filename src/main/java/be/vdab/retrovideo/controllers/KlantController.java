package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.forms.FamilienaamForm;
import be.vdab.retrovideo.services.KlantService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("klanten")
class KlantController {
    private final KlantService klantService;

    KlantController(KlantService klantService) {
        this.klantService = klantService;
    }

    @GetMapping("zoekKlant")
    public ModelAndView familienaamForm(){
        return new ModelAndView("klanten").addObject(new FamilienaamForm(null));
    }

    @GetMapping
    public ModelAndView familienaam(@Valid FamilienaamForm form, Errors errors){
        var modelAndView = new ModelAndView("klanten");
        if (errors.hasErrors()){
            return modelAndView;
        }
        return modelAndView.addObject("klantengevonden", klantService.findByFamilienaamBevat(form.getFamilienaamBevat()));
    }
}
