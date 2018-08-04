package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.FilmSession;
import org.softuni.cinemasystem.entities.Row;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowRepository  extends JpaRepository<Row,String> {
}
