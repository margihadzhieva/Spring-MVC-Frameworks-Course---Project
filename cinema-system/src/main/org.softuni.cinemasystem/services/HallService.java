package org.softuni.cinemasystem.services;


import org.softuni.cinemasystem.models.binding.HallAddBindingModel;
import org.softuni.cinemasystem.models.service.HallServiceModel;

import java.util.Set;

public interface HallService {
    void createHall (HallServiceModel HallServiceModel);

    void deleteHallById(String Id);

    Set<HallServiceModel> getAllHalls();

    HallServiceModel getHallByID(String Id);

    Set<HallServiceModel> getHallsByCinemaId(String Id);

  //  void createHall(HallAddBindingModel hallAddBindingModel);


    // void createHall(HallAddBindingModel hallServiceModel);
}
