package org.softuni.cinemasystem.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "hall")
public class Hall extends BaseEntity {


    private String hallName;


    private Set<Cinema> cinemas;


    private Set<FilmSession>  filmSessions;


    private Set<Row> rows;

    public Hall() {
        this.cinemas = new HashSet<>();

    }

    @Column(nullable = false)
    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
    @ManyToMany
    @JoinTable(name = "cinemas_halls")
    public Set<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
    @OneToMany(mappedBy = "hall")
    public Set<FilmSession> getFilmSessions() {
        return filmSessions;
    }

    public void setFilmSessions(Set<FilmSession> filmSessions) {
        this.filmSessions = filmSessions;
    }
    @OneToMany
    public Set<Row> getRows() {
        return rows;
    }

    public void setRows(Set<Row> rows) {
        this.rows = rows;
    }
}
