package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository <Film, String> {
}
