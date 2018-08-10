package org.softuni.cinemasystem.models.service;

import org.softuni.cinemasystem.entities.BaseEntity;
import org.softuni.cinemasystem.entities.Cinema;
import org.softuni.cinemasystem.entities.FilmSession;
import org.softuni.cinemasystem.entities.Row;

import javax.persistence.*;
import java.util.Set;

public class HallServiceModel {

        private String hallName;

        private Cinema cinema;

    private Seats rows;


        private Set<FilmSession>  filmSessions;

        public Hall() {

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

        public Set<Row> getRows() {
            return rows;
        }

        public void setRows(Set<Row> rows) {
            this.rows = rows;
        }

        public Set<FilmSession> getFilmSessions() {
            return filmSessions;
        }

        public void setFilmSessions(Set<FilmSession> filmSessions) {
            this.filmSessions = filmSessions;
        }
    }

}
