package org.softuni.cinemasystem.services;

import org.softuni.cinemasystem.models.service.FilmServiceModel;

import java.util.Set;

public interface FilmService {

    boolean addFilm(FilmServiceModel filmServiceModel);

    Set<FilmServiceModel> getAll();

}
