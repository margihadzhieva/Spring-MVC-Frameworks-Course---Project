package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.FilmSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmSessionRepository extends JpaRepository<FilmSession,String> {
}
