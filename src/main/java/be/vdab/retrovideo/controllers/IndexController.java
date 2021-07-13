package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.services.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {
    private final GenreService genreService;

    IndexController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index", "genres", genreService.findAll());
    }

    @GetMapping("genre/{id}")
    public ModelAndView films(@PathVariable long id){
            return new ModelAndView("index", "film",)
    }
}
