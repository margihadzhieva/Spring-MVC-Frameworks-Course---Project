package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository <Film, String> {
    Film findByTitle(String name);
}
