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
@Transactional
public class CinemaServiceImpl implements CinemaService{
    private CinemaRepository cinemaRepository;

    private final ModelMapper modelMapper;


    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createCinema(CinemaServiceModel cinema) {
            Cinema cinemaEntity = modelMapper.map(cinema, Cinema.class);
            this.cinemaRepository.save(cinemaEntity);
        }

    @Override
    public Set<CinemaServiceModel> getAll() {
        return this.cinemaRepository
                .findAll()
                .stream()
                .map(x-> this.modelMapper.map(x, CinemaServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }
}



