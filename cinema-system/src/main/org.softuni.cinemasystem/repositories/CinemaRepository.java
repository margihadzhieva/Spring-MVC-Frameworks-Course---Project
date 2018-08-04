package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CinemaRepository extends JpaRepository<Cinema, String> {
}
