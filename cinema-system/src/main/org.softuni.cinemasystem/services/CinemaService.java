package org.softuni.cinemasystem.services;

import org.softuni.cinemasystem.entities.Cinema;
import org.softuni.cinemasystem.models.binding.CinemaCreateBindingModel;
import org.softuni.cinemasystem.models.service.CinemaServiceModel;

import java.util.List;
import java.util.Set;

public interface CinemaService {



    void createCinema(CinemaServiceModel cinema);

    Set<CinemaServiceModel> getAll();


}
