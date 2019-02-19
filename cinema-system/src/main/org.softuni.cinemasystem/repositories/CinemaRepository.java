package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, String> {
   Cinema findByCinemaName(String cinemaName);

   Optional<Cinema> findById(String id);

}



