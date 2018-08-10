package org.softuni.cinemasystem.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "hall")
public class Hall extends BaseEntity {


    private String hallName;



    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;


    @OneToMany(mappedBy = "hall")
    private Set<Seat> Seats;

    @OneToMany(mappedBy = "hall")
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
