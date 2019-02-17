package org.softuni.cinemasystem.services;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.entities.Cinema;
import org.softuni.cinemasystem.entities.Hall;
import org.softuni.cinemasystem.models.binding.HallAddBindingModel;
import org.softuni.cinemasystem.models.service.HallServiceModel;
import org.softuni.cinemasystem.repositories.CinemaRepository;
import org.softuni.cinemasystem.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    private final CinemaRepository cinemaRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository, CinemaService cinemaService, CinemaRepository cinemaRepository, ModelMapper modelMapper) {
        this.hallRepository = hallRepository;
        this.cinemaRepository = cinemaRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createHall(HallServiceModel hallServiceModel) {
        Hall hallEntity = this.modelMapper.map(hallServiceModel, Hall.class);

        this.hallRepository.save(hallEntity);
    }

    @Override
    public void deleteHallById(String Id) {


    }

    @Override
    public Set<HallServiceModel> getAllHalls() {
        return this
                .hallRepository
                .findAll()
                .stream()
                .map(x -> this.modelMapper.map(x, HallServiceModel.class))
                .collect(Collectors.toSet());

    }

    @Override
    public HallServiceModel getHallByID(String id) {
        Hall hallEntity = this.hallRepository.getOne(id);

        return this.modelMapper.map(hallEntity, HallServiceModel.class);
    }

//    @Override
//    public void createHall(HallAddBindingModel hall) {
//        Hall hallEntity = this.modelMapper.map(hall, Hall.class);
//
//
//        this.hallRepository.save(hallEntity);

    //}
}
