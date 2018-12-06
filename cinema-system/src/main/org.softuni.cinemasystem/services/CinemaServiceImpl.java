package org.softuni.cinemasystem.services;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.entities.Cinema;
import org.softuni.cinemasystem.models.binding.CinemaCreateBindingModel;
import org.softuni.cinemasystem.models.service.CinemaServiceModel;
import org.softuni.cinemasystem.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService{
    private CinemaRepository cinemaRepository;

    private final ModelMapper modelMapper;


    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addCinema(CinemaServiceModel cinemaServiceModel) {
        Cinema cinemaEntity = this.modelMapper.map(cinemaServiceModel, Cinema.class);
        try {
            this.cinemaRepository.save(cinemaEntity);
        } catch (Exception ignore)
        {
        return false;
      }
    return  true;}


    @Override
    public Set<CinemaServiceModel> getAll() {
        return this.cinemaRepository
                .findAll()
                .stream()
                .map(x-> this.modelMapper.map(x, CinemaServiceModel.class))
                .collect(Collectors.toSet());
    }
}



