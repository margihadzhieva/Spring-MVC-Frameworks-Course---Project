package org.softuni.cinemasystem.entities;


import javax.persistence.*;

@Entity
    @Table(name ="ticket")
    public class Ticket extends BaseEntity {

    private Seat seat;

    private Double price;

    private FilmSession filmSession;

    private User user;

    public Ticket() {
    }
    @Embedded
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    @Column
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @ManyToOne
    @JoinColumn(name = "film_session_id")
    public FilmSession getFilmSession() {
        return filmSession;
    }

    public void setFilmSession(FilmSession filmSession) {
        this.filmSession = filmSession;
    }
    @ManyToOne
    @JoinColumn(name = "username")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}




