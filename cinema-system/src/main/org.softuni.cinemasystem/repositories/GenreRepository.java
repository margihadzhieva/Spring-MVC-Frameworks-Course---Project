package org.softuni.cinemasystem.repositories;


import org.softuni.cinemasystem.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository  extends JpaRepository<Genre,String> {
}
