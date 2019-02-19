package org.softuni.cinemasystem.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "hall")
public class Hall extends BaseEntity {


    private String hallName;

    private Integer seats;

    private Cinema cinema;


    private Set<FilmSession>  filmSessions;




 //   private Set<Row> rows;

    public Hall() {


    }

    @Column(nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @OneToMany(mappedBy = "hall")
    public Set<FilmSession> getFilmSessions() {
        return filmSessions;
    }

    public void setFilmSessions(Set<FilmSession> filmSessions) {
        this.filmSessions = filmSessions;
    }
//    @OneToMany
//    public Set<Row> getRows() {
//        return rows;
//    }
//
//    public void setRows(Set<Row> rows) {
//        this.rows = rows;
//    }
}
