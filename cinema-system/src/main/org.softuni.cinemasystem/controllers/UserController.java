package org.softuni.cinemasystem.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.models.binding.UserRegisterBindingModel;
import org.softuni.cinemasystem.models.service.UserServiceModel;
import org.softuni.cinemasystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController extends BaseController {
    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return this.view("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return this.view("register");
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel) {
        if(!userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            return this.view("register");
        }

        this.userService.createUser(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return this.redirect("/");
    }
}

