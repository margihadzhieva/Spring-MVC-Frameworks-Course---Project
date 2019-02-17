package org.softuni.cinemasystem.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.models.binding.HallAddBindingModel;
import org.softuni.cinemasystem.models.service.CinemaServiceModel;
import org.softuni.cinemasystem.models.service.HallServiceModel;
import org.softuni.cinemasystem.models.view.AddHallViewModel;
import org.softuni.cinemasystem.models.view.AllHallViewModel;
import org.softuni.cinemasystem.services.CinemaService;
import org.softuni.cinemasystem.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HallController extends BaseController {


    private final HallService hallService;

    private final CinemaService cinemaService;

    private final ModelMapper modelMapper;

    @Autowired
    public HallController(HallService hallService, CinemaService cinemaService, ModelMapper modelMapper) {

        this.hallService = hallService;
        this.cinemaService = cinemaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/admin/hall")
    public ModelAndView allHalls(ModelAndView modelAndView) {
        Set<AllHallViewModel> allHallViewModel = this
                .hallService
                .getAllHalls()
                .stream()
                .map(x -> this.modelMapper.map(x, AllHallViewModel.class))
                .collect(Collectors.toSet());

        modelAndView.addObject("allHalls", allHallViewModel);

        //   modelAndView.setViewName("/admin/hall-all");
        return this.view("/admin/hall-all", modelAndView);

    }


    @GetMapping("/admin/hall/add")
    public ModelAndView addHall(ModelAndView modelAndView, Model model) {
        modelAndView.setViewName("/admin/hall-add");


        if(!model.containsAttribute("hallInput")) {
            model.addAttribute("hallInput", new HallAddBindingModel());
        }

        AddHallViewModel viewModel = new AddHallViewModel();


        for (CinemaServiceModel cinemaServiceModel : this.cinemaService.getAll()) {
            viewModel.getCinemas().add(cinemaServiceModel.getCinemaName());
        }



       // AllHallViewModel viewModel = new AllHallViewModel();
       // modelAndView.addObject("cinemas", cinemaService.getAll());
        modelAndView.addObject("HallViewModel", viewModel);
        return modelAndView;

    }

//    @PostMapping("/admin/hall/add")
//    public String addHall(HallAddBindingModel hallAddBindingModel, BindingResult bindingResult, Model model) {
//
//        this.hallService.createHall(this.modelMapper
//                .map(hallAddBindingModel
//                        , HallServiceModel.class));
//        return "redirect:/admin";
//    }


//    @PostMapping("/admin/hall/add")
//    public ModelAndView addVirusConfirm(@ModelAttribute(name = "hallInput") HallAddBindingModel hallAddBindingModel,
//                                        BindingResult bindingResult,
//                                        ModelAndView modelAndView) {
//        if (bindingResult.hasErrors()) {
//
//            modelAndView.setViewName("redirect:add");
//        } else {
//            this.hallService.createHall(hallAddBindingModel);
//            modelAndView.setViewName("redirect:index");
//        }
//
//            return modelAndView;
//        }

    }

