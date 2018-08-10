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
public class CinemaController extends BaseController {

    private CinemaService cinemaService;
    private final ModelMapper modelMapper;


    public CinemaController(CinemaService cinemaService, ModelMapper modelMapper) {
        this.cinemaService = cinemaService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/admin")
    public ModelAndView adminIndexPage() {
        return new ModelAndView("/admin/index");

    }


    @GetMapping("/admin/cinema/all")
    public ModelAndView allCinemas(ModelAndView modelAndView){
        Set<AllCinemaViewModel> allCinemaVModel = this
                .cinemaService
                .getAll()
                .stream()
                .map(x -> this.modelMapper.map(x, AllCinemaViewModel.class))
                .collect(Collectors.toUnmodifiableSet());

        modelAndView.addObject("allCinemas", allCinemaVModel);

     //   modelAndView.setViewName("/admin/cinema-all");
        return this.view("/admin/cinema-all", modelAndView);

    }



    @GetMapping("/admin/cinema/add")
    public ModelAndView addCinema(ModelAndView modelAndView, Model model) {
        modelAndView.setViewName("/admin/cinema-add");
        AllCinemaViewModel viewModel = new AllCinemaViewModel();
        modelAndView.addObject("CinemaViewModel", viewModel);
        return modelAndView;

    }

    @RequestMapping(value = "/admin/cinema/add", method = RequestMethod.POST)
    public String addCinema(CinemaCreateBindingModel cinemaCreateBindingModel, BindingResult bindingResult, Model model) {
        this.cinemaService.createCinema(this.modelMapper
                .map(cinemaCreateBindingModel
                        , CinemaServiceModel.class));
        return "redirect:/admin";
    }


}
