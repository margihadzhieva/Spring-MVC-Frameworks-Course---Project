package org.softuni.cinemasystem.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.models.binding.CinemaCreateBindingModel;
import org.softuni.cinemasystem.models.service.CinemaServiceModel;
import org.softuni.cinemasystem.models.view.AllCinemaViewModel;
import org.softuni.cinemasystem.services.CinemaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cinema")
public class CinemaController extends BaseController {

    private CinemaService cinemaService;
    private final ModelMapper modelMapper;


    public CinemaController(CinemaService cinemaService, ModelMapper modelMapper) {
        this.cinemaService = cinemaService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public ModelAndView adminIndexPage() {
        return new ModelAndView("/cinema-add");

    }


    @GetMapping("/all")
    public ModelAndView allCinemas(ModelAndView modelAndView){
        Set<AllCinemaViewModel> allCinemaVModel = this
                .cinemaService
                .getAll()
                .stream()
                .map(x -> this.modelMapper.map(x, AllCinemaViewModel.class))
                .collect(Collectors.toSet());

        modelAndView.addObject("allCinemas", allCinemaVModel);


        return this.view("cinema-all", modelAndView);

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCinema(CinemaCreateBindingModel cinemaCreateBindingModel, BindingResult bindingResult, Model model) {
        this.cinemaService.addCinema(this.modelMapper
                .map(cinemaCreateBindingModel
                        , CinemaServiceModel.class));
        return "redirect:/admin";
    }


}
