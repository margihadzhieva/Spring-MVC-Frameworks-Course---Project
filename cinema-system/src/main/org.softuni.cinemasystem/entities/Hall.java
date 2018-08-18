package org.softuni.cinemasystem.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "hall")
public class Hall extends BaseEntity {

    @Column(nullable = false)
    private String hallName;

    @ManyToMany
    @JoinTable(name = "cinemas_halls")
    private Set<Cinema> cinemas;

    @OneToMany(mappedBy = "hall")
    private Set<FilmSession>  filmSessions;

    @OneToMany
    private Set<Row> rows;

    public Hall() {
        this.cinemas = new HashSet<>();

    }


    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Set<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public Set<FilmSession> getFilmSessions() {
        return filmSessions;
    }

    public void setFilmSessions(Set<FilmSession> filmSessions) {
        this.filmSessions = filmSessions;
    }

    public Set<Row> getRows() {
        return rows;
    }

    public void setRows(Set<Row> rows) {
        this.rows = rows;
    }
}
