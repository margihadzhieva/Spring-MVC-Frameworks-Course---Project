package org.softuni.cinemasystem.models.service;


import org.softuni.cinemasystem.entities.Cinema;
import org.softuni.cinemasystem.entities.FilmSession;
import org.softuni.cinemasystem.entities.Hall;

import java.util.Set;

public class HallServiceModel {

    private String Id;

    private String hallName;

    private Integer seats;

    private Cinema cinema;

    public HallServiceModel() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}





