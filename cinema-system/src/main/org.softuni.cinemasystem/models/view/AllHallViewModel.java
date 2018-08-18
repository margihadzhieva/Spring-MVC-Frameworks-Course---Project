package org.softuni.cinemasystem.models.view;

import org.softuni.cinemasystem.entities.Cinema;

import java.util.Set;

public class AllHallViewModel {


    private String Id;

    private String hallName;


    private Cinema cinema;


    private Set<String> Seats;


    private Set<String> filmSessions;

    private Set<String> rows;

    public AllHallViewModel() {
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

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Set<String> getSeats() {
        return Seats;
    }

    public void setSeats(Set<String> seats) {
        Seats = seats;
    }

    public Set<String> getFilmSessions() {
        return filmSessions;
    }

    public void setFilmSessions(Set<String> filmSessions) {
        this.filmSessions = filmSessions;
    }

    public Set<String> getRows() {
        return rows;
    }

    public void setRows(Set<String> rows) {
        this.rows = rows;
    }


}
