package org.softuni.cinemasystem.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.services.CinemaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private CinemaService cinemaService;
    private final ModelMapper modelMapper;

    public HomeController(CinemaService cinemaService, ModelMapper modelMapper) {
        this.cinemaService = cinemaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index.html");
    }


    }
