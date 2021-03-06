package org.softuni.cinemasystem.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "film_session")
public class FilmSession extends BaseEntity {

    private LocalDateTime startTime;

    private Film film;

    private Cinema cinema;

    private Hall hall;

    private Integer remainingTickets;

    private Integer tickets;


    public FilmSession() {
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @ManyToOne
    @JoinColumn(name = "film")
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @ManyToOne
    @JoinColumn(name = "hall")
    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @ManyToOne
    @JoinColumn(name = "cinema")
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Integer getRemainingTickets() {
        return remainingTickets;
    }

    public void setRemainingTickets(Integer remainingTickets) {
        this.remainingTickets = remainingTickets;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }
}