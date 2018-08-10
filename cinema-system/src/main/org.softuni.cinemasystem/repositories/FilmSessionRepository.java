package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.FilmSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmSessionRepository extends JpaRepository<FilmSession,String> {
}
