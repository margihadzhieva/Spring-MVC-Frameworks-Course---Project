package org.softuni.cinemasystem.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "film_session")
public class FilmSession extends BaseEntity {

    private LocalDateTime time;

    private Film film;

    private Hall hall;

    private Set<Ticket> tickets;


    public FilmSession() {
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name = "film_id")
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

    @OneToMany(mappedBy = "filmSession")
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}