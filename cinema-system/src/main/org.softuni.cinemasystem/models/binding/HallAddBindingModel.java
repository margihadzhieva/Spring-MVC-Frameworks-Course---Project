package org.softuni.cinemasystem.models.binding;

import org.softuni.cinemasystem.entities.Cinema;
import org.softuni.cinemasystem.entities.FilmSession;

import java.util.Set;

public class HallAddBindingModel {

    private String cinemaId;
    private String hallName;

    private Integer seats;



    private String test;

    public HallAddBindingModel() {
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
