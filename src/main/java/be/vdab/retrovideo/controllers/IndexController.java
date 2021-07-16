package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.services.FilmService;
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
    private final FilmService filmService;

    IndexController(GenreService genreService, FilmService filmService) {
        this.genreService = genreService;
        this.filmService = filmService;
    }

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index", "genres", genreService.findAll());
    }

    @GetMapping("genre/{id}")
    public ModelAndView films(@PathVariable long id) {
        var modelAndView = new ModelAndView("index", "genres", genreService.findAll());
        return modelAndView.addObject("films", filmService.findByGenre(id))
                .addObject("genreUniek", genreService.findById(id));
    }
}
