package org.softuni.cinemasystem.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.models.binding.CinemaCreateBindingModel;
import org.softuni.cinemasystem.models.binding.HallAddBindingModel;
import org.softuni.cinemasystem.models.service.CinemaServiceModel;
import org.softuni.cinemasystem.models.view.AllCinemaViewModel;
import org.softuni.cinemasystem.models.view.AllHallViewModel;
import org.softuni.cinemasystem.services.CinemaService;
import org.softuni.cinemasystem.services.HallService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cinema")
public class CinemaController extends BaseController {

    private CinemaService cinemaService;
    private final ModelMapper modelMapper;
    private HallService hallService;


    public CinemaController(CinemaService cinemaService, ModelMapper modelMapper) {
        this.cinemaService = cinemaService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public ModelAndView adminIndexPage() {
        return new ModelAndView("/cinema-add");

    }


    @GetMapping("/all")
    public ModelAndView allCinemas(ModelAndView modelAndView) {
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
    public ModelAndView addCinema(@ModelAttribute CinemaCreateBindingModel cinemaCreateBindingModel) {
        this.cinemaService.addCinema(this.modelMapper
                .map(cinemaCreateBindingModel
                        , CinemaServiceModel.class));
        return this.redirect("all");
    }


    @RequestMapping(value = "/addhall", method = RequestMethod.POST)
    public ModelAndView addHall(@ModelAttribute HallAddBindingModel hallAddBindingModel, Principal principal) {
        this.cinemaService
                .addHall(hallAddBindingModel.getCinemaId(), hallAddBindingModel.getHallName(), hallAddBindingModel.getSeats());


        return this.redirect("all");
        //String cinemaId, String hallName, Integer seats


//

    }

//    @GetMapping(value = "/test")
//    public ModelAndView test(String cinemaId, ModelAndView modelAndView) {
//        Set<AllHallViewModel> allHallViewModel = this
//                .hallService
//                .getAllHalls()
//                .stream()
//                .map(x -> this.modelMapper.map(x, AllHallViewModel.class))
//                .collect(Collectors.toSet());
//
//        modelAndView.addObject("allHalls", allHallViewModel);
//        return this.view("cinema-all", modelAndView);
//
//
//    }


}
