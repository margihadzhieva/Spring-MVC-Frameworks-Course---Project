package org.softuni.cinemasystem.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.models.binding.FilmAddBindingModel;
import org.softuni.cinemasystem.models.service.FilmServiceModel;
import org.softuni.cinemasystem.models.view.AllCinemaViewModel;
import org.softuni.cinemasystem.models.view.AllFilmsViewModel;
import org.softuni.cinemasystem.services.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/film")
public class FilmController extends  BaseController {

    private final FilmService filmService;

    private final ModelMapper modelMapper;

    public FilmController(FilmService filmService, ModelMapper modelMapper) {
        this.filmService = filmService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView addFilm() {
        return new ModelAndView("/film-add");
    }

    @PostMapping("/add")
    public ModelAndView addFilmConfirm (@ModelAttribute FilmAddBindingModel filmAddBindingModel){
        boolean result = this.filmService
                .addFilm(this.modelMapper.map(filmAddBindingModel, FilmServiceModel.class));

        if(!result) {
            throw new IllegalArgumentException("asd");
        }

        return this.redirect("add");
    }


    @GetMapping("/all")
    public ModelAndView allFils(ModelAndView modelAndView) {
        Set<AllFilmsViewModel> allFilmsViewModels = this
                .filmService
                .getAll()
                .stream()
                .map(x -> this.modelMapper.map(x, AllFilmsViewModel.class))
                .collect(Collectors.toSet());

        modelAndView.addObject("allFilms", allFilmsViewModels);


        return this.view("film-all", modelAndView);

    }


}

