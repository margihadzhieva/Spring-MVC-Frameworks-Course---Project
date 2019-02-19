package org.softuni.cinemasystem.services;
import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.entities.Cinema;
import org.softuni.cinemasystem.models.service.CinemaServiceModel;
import org.softuni.cinemasystem.models.service.HallServiceModel;
import org.softuni.cinemasystem.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService{
    private CinemaRepository cinemaRepository;

    private final ModelMapper modelMapper;

    private final HallService hallService;


    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository, ModelMapper modelMapper, @Lazy HallService hallService) {
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;

        this.hallService = hallService;
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


    @Override
    public void addHall(String cinemaId, String hallName, Integer seats) {
        Cinema cinema = this.cinemaRepository.findById(cinemaId)
                .orElse(null);

        if(cinema == null){
            throw new IllegalArgumentException("Cinema can not be null");

        }

        HallServiceModel hallServiceModel = new HallServiceModel();

       hallServiceModel.setCinema(cinema);

        hallServiceModel.setHallName(hallName);

        hallServiceModel.setSeats(seats);

        this.hallService.createHall(hallServiceModel);


    }

    @Override
    public String getCinemaNameById(String cinemaId) {
        Cinema cinema = this.cinemaRepository.findById(cinemaId)
                .orElse(null);


    return cinema.getCinemaName();
    }
}



