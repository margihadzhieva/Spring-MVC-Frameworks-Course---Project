package org.softuni.cinemasystem.models.service;


import org.softuni.cinemasystem.entities.Cinema;
import org.softuni.cinemasystem.entities.FilmSession;
import org.softuni.cinemasystem.entities.Row;

import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

public class HallServiceModel {


    private String hallName;


    private Set<String> cinemas;


    private Set<String> filmSessions;


    private Set<String> rows;

    public HallServiceModel() {
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Set<String> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<String> cinemas) {
        this.cinemas = cinemas;
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





