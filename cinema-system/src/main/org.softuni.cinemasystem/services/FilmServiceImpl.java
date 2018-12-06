package org.softuni.cinemasystem.services;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.entities.Film;
import org.softuni.cinemasystem.models.service.FilmServiceModel;
import org.softuni.cinemasystem.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FilmServiceImpl implements FilmService {
  private final  FilmRepository filmRepository;

  private final ModelMapper modelMapper;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean addFilm(FilmServiceModel filmServiceModel) {
        Film filmEntity = this.modelMapper.map(filmServiceModel, Film.class);

        try {
            this.filmRepository.save(filmEntity);
        } catch (Exception ignore){
        return false;}

        return true;
    }

    @Override
    public Set<FilmServiceModel> getAll() {
        return null;
    }
}
